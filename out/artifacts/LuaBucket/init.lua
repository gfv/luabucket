-- Almost trivial LuaBucket snip loader.
-- It traverses through snip list and executes each in a protected environment, 
-- without the ability to alter global variables and without access to snip list.
-- Also, print() function is redirected to logger.

local function map(func, array)
  local new_array = {}
  for i,v in ipairs(array) do
    new_array[i] = func(v)
  end
  return new_array
end

function safe_print (...)
	sp = table.concat(map(tostring, {...}), "\t")
	logger:info("[LuaBucket init] " .. sp)
end
print = safe_print

function load_snip(snip)
	local function map(func, array)
		local new_array = {}
		for i,v in ipairs(array) do
			new_array[i] = func(v)
		end
		return new_array
	end
	
	local event_type = luajava.bindClass("org.bukkit.event.Event")
	local safe_print = function (...)
		sp = table.concat(map(tostring, {...}), "\t")
		logger:info("[LB: " .. snip.name .."] " .. sp)
	end
	
	local protected_rc = function (dsp, command, listener) return dispatcher.registerCommand(dispatcher, snip.name, command, listener) end
	local protected_rl = function (dsp, event, listener) return dispatcher.registerListener(dispatcher, snip.name, event, listener) end
	local protected_sdt = function (dsp, func, delay, async) return dispatcher.scheduleDelayedTask(dispatcher, snip.name, func, delay, async) end
	local server = dispatcher:getServer()
	local meta_dispatcher = {
		registerCommand=protected_rc,
		registerListener=protected_rl,
		scheduleDelayedTask=protected_sdt
		}
	
	local safe_env = {assert=assert,
		create=create,
		error=error,
		ipairs=ipairs,
		loadstring=loadstring,
		next=next,
		pairs=pairs,
		pcall=pcall,
		print=safe_print,
		select=select,
		tonumber=tonumber,
		tostring=tostring,
		type=type,
		unpack=unpack,
		setfenv=setfenv,
		_VERSION=_VERSION,
		xpcall=xpcall,
		require=require,
		string={byte=string.byte, char=string.char, find=string.find, format=string.format, gmatch=string.gmatch, gsub=string.gsub, len=string.len, lower=string.lower, match=string.match, rep=string.rep, reverse=string.reverse, sub=string.sub, upper=string.upper},
		table={insert=table.insert, maxn=table.maxn, remove=table.remove, sort=table.sort, concat=table.concat},
		math={abs=math.abs,acos=math.acos,asin=math.asin,atan=math.atan,atan2=math.atan2,ceil=math.ceil,cos=math.cos,cosh=math.cosh,deg=math.deg,exp=math.exp,floor=math.floor,fmod=math.fmod,frexp=math.frexp,huge=math.huge,ldexp=math.ldexp,log=math.log,log10=math.log10,max=math.max,min=math.min,modf=math.modf,pi=math.pi,pow=math.pow,rad=math.rad,random=math.random,sin=math.sin,sinh=math.sinh,sqrt=math.sqrt, tan=math.tan, tanh=math.tanh},
		io={read=io.read,write=io.write,flush=io.flush,type=io.type},
		os={clock=os.clock,difftime=os.difftime,time=os.time},
		luajava={bindClass=luajava.bindClass, newInstance=luajava.newInstance, new=luajava.new, createProxy=luajava.createProxy, loadLib=luajava.loadLib},

		dispatcher=meta_dispatcher, assistant=assistant, logger=logger, server=server, mc=mc,
		server=server
	}
	safe_env._G = safe_env
	
	local snip_string = ""
	if snip.string == nil then
		local fh = io.open(snip.path)
		if not fh then return nil, "could not open file" end
		snip_string = fh:read("*a")
		fh:close()
	else
		snip_string = snip.string
	end
	
	local f, message = loadstring(snip_string)
	if not f then
		print ("could not load snip " .. snip.name .. ": " .. message)
		return nil
	end
	setfenv(f, safe_env)
	return pcall(f)
end

for index,value in ipairs(sniplist) do
	print ("running snip " .. value.name)
	local rv, msg = load_snip(value)
	if rv == false then logger:warning("failed running snip " .. value.name .. " because of " .. msg) end
end

return load_snip