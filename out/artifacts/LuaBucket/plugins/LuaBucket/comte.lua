e = _G

function test (sender, args)
	local print = function (...)
		local s_t = {}
		for i,v in ipairs({...}) do
			s_t[i] = tostring(v)
		end
		sp = table.concat(s_t, "\t")
		sender:sendMessage("Lua: " .. sp)
	end
	e.print = print
	e.sender = sender
	
	local cm = string.sub(args, string.find(args, ' ')+1)
	print("> §b" .. cm)
	local chunk, err = loadstring("return " .. cm)
	if not chunk then
		chunk, err = loadstring(cm)
		if not chunk then
			print("§c" .. err)
			return
		end
	end
	setfenv(chunk, e)
	local st, rv = pcall(chunk)
	if not st then print("§c" .. rv)
	else if rv ~= nil then print("§6" .. tostring(rv)) end end	
end

dispatcher:registerCommand("lc", test)