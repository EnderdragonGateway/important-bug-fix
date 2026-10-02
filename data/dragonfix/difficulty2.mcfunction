execute as @e[type=minecraft:dragon_fireball] at @s run summon area_effect_cloud ~ ~ ~ {potion_duration_scale:1,custom_particle:{type:"minecraft:dragon_breath",power:1.0f},ReapplicationDelay:0,WaitTime:0,Radius:1f,RadiusPerTick:0.1f,Duration:10,potion_contents:{"custom_color":7561558,custom_effects:[{id:"minecraft:instant_damage",amplifier:2,duration:1}]},Tags:["dragonbreath"]}
execute at @s run execute as @e[type=minecraft:player,distance=..5] run damage @s 0.8 minecraft:dragon_breath

execute at @s if data entity @s {DragonPhase:7} run execute as @e[distance=8..192] run effect give @s minecraft:slowness 1 6
execute at @s if data entity @s {DragonPhase:8} run execute as @e[distance=16..192] run effect give @s minecraft:darkness 5 0
execute at @s if data entity @s {DragonPhase:8} run execute as @e[distance=16..192] run effect give @s minecraft:blindness 5 0