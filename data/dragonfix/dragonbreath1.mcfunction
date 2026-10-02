summon area_effect_cloud ~ ~.6 ~ {potion_duration_scale:1,custom_particle:{type:"minecraft:dragon_breath",power:1.0f},ReapplicationDelay:0,WaitTime:0,Radius:6f,RadiusPerTick:-0.0025f,Duration:2400,potion_contents:{"custom_color":7561558,custom_effects:[{id:"minecraft:instant_damage",amplifier:2,duration:1}]},Tags:["dragonbreath"]}
execute at @s if data entity @s {Tags:["dragonbreath"]} run data modify entity @s Owner set from entity @e[type=minecraft:ender_dragon,limit=1,sort=nearest] UUID
execute at @s unless data entity @s {Tags:["dragonbreath"]} run kill @s
