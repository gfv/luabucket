function dmg(event)
	if assistant:isPlayer(event:getEntity()) then
		event:setCancelled(true)
	end
end

dispatcher:registerListener(mc.event.type.ENTITY_DAMAGE, dmg)