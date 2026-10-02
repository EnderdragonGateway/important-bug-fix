scoreboard players set Speed Temp 9

#Mixin如果未修复速度问题，可在数据包启用此项
#execute as @e[type=minecraft:ender_dragon] unless data entity @s {DragonPhase:5} unless data entity @s {DragonPhase:6} unless data entity @s {DragonPhase:7} run function dragonfix:ai

execute as @e[type=minecraft:ender_dragon] unless data entity @s {Tags:["Jean"]} run function dragonfix:dragondata

#execute in the_end as @e[type=minecraft:ender_dragon] at @s if entity @s run worldborder set 256
#execute in the_end as @a unless entity @e[type=minecraft:ender_dragon] run worldborder set 59999968
#原版59999968硬编码最大值，用Mod改无法保证版本兼容，事实上我认为应该把实体坐标和世界边界限制在67108864和67105984以内

function dragonfix:equip_helmet
#execute as @e[type=minecraft:end_crystal] run data modify entity @s ShowBottom set value 1b

execute if score @p DragonDifficulty matches 0 run execute as @e[type=minecraft:ender_dragon] at @s run function dragonfix:classic0

execute if score @p DragonDifficulty matches 1 run execute as @e[type=minecraft:ender_dragon] run execute in the_end as @e[type=minecraft:area_effect_cloud] positioned as @s unless data entity @s {Tags:["dragonbreath"]} run function dragonfix:dragonbreath1
execute if score @p DragonDifficulty matches 1 run execute as @e[type=minecraft:ender_dragon] run function dragonfix:fireball1
execute if score @p DragonDifficulty matches 1 run execute as @e[type=minecraft:ender_dragon] run function dragonfix:difficulty1

execute if score @p DragonDifficulty matches 2 run execute as @e[type=minecraft:ender_dragon] run execute in the_end as @e[type=minecraft:area_effect_cloud] positioned as @s unless data entity @s {Tags:["dragonbreath"]} run function dragonfix:dragonbreath2
execute if score @p DragonDifficulty matches 2 run execute as @e[type=minecraft:ender_dragon] run function dragonfix:fireball2
execute if score @p DragonDifficulty matches 2 run execute as @e[type=minecraft:ender_dragon] run function dragonfix:difficulty2

execute if score @p DragonDifficulty matches 3 run execute as @e[type=minecraft:ender_dragon] run execute in the_end as @e[type=minecraft:area_effect_cloud] positioned as @s unless data entity @s {Tags:["dragonbreath"]} run function dragonfix:dragonbreath3
execute if score @p DragonDifficulty matches 3 run execute as @e[type=minecraft:ender_dragon] run function dragonfix:fireball3
execute if score @p DragonDifficulty matches 3 run execute as @e[type=minecraft:ender_dragon] run function dragonfix:difficulty3

execute if score @p DragonDifficulty matches 4 run execute as @e[type=minecraft:ender_dragon] run execute in the_end as @e[type=minecraft:area_effect_cloud] positioned as @s unless data entity @s {Tags:["dragonbreath"]} run function dragonfix:dragonbreath4
execute if score @p DragonDifficulty matches 4 run execute as @e[type=minecraft:ender_dragon] run function dragonfix:difficulty4
