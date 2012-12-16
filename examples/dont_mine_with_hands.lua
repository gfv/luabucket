function oh_the_pain(event)
	local player = event:getPlayer()
	if event:getMaterial():equals(mc.material.AIR) then
		if event:getAction():equals(mc.action.LEFT_CLICK_BLOCK) then
			player:damage(1)
		end
	end
end

dispatcher:registerListener(mc.event.PLAYER_INTERACT, oh_the_pain)