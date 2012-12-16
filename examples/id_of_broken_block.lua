function broken(event)
	local player = event:getPlayer()
	local block = event:getBlock()
	local id = block:getTypeId()
	player:chat("i broke block id " .. id)
end

dispatcher:registerListener(mc.event.BLOCK_BREAK, broken) 