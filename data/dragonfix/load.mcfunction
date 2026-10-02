scoreboard objectives add Settings dummy
scoreboard objectives add Temp dummy
scoreboard objectives add YPos dummy
scoreboard objectives add PrevY dummy
scoreboard objectives add YDiff dummy
scoreboard objectives add YVel dummy
scoreboard objectives add DMFSettings dummy

scoreboard objectives add DragonDifficulty dummy
function dragonfix:settings

#reference in case i need it
scoreboard objectives add DragonPhase dummy

scoreboard players set Loaded Temp 1

#Display a message saying the pack loaded successfully
#execute unless score SilentStart DMFSettings matches 1 run tellraw @a {"text":"末影龙行为更正为1.9-1.13版本的状态(y轴速度增加值扩大10倍,修复了MC-197201,MC-272431等一系列问题)","color":"dark_purple"}
#execute as @a if score @s DragonDifficulty matches 0 run tellraw @s {"text":"末影龙Jean:原版强度,Java版(1.14+漏洞影响和1.9前:5,1.9-1.13:20);基岩版(1.0-1.16:30,1.16+:20)","color":"dark_green"}
#execute as @a if score @s DragonDifficulty matches 1 run tellraw @s {"text":"末影龙Jean:简单模式1,强度25,基本等于基岩版,新手玩家的选择","color":"dark_blue"}
#execute as @a if score @s DragonDifficulty matches 2 run tellraw @s {"text":"末影龙Jean:普通模式2,强度45,约为普通难度的灾变雷电海妖Scylla,最适合Boss的强度","color":"light_purple"}
#execute as @a if score @s DragonDifficulty matches 3 run tellraw @s {"text":"末影龙Jean:困难模式3,强度50,约为困难难度的灾变雷电海妖Scylla,最适合做挑战的强度","color":"gold"}
#execute as @a if score @s DragonDifficulty matches 4 run tellraw @s {"text":"末影龙Jean:噩梦模式4,强度100,即使身着冰与火之歌的坚硬龙霜护甲,也将被魔法伤害彻底摧毁","color":"dark_red"}

#Armor Stand Arms, Crystal Bottoms, WorldBorder NoDamage
execute as @e[type=minecraft:armor_stand] unless data entity @s {ShowArms:1b} run data modify entity @s ShowArms set value 1b
execute as @e[type=minecraft:end_crystal] run data modify entity @s ShowBottom set value 1b

execute in overworld run worldborder damage amount 0
execute in the_end run worldborder damage amount 0
execute in the_nether run worldborder damage amount 0
