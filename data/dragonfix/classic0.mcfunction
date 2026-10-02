execute as @s run execute as @e[type=minecraft:player,distance=..5] run effect give @s minecraft:wither 1 2

tp @e[type=minecraft:dragon_fireball] @p
execute as @e[type=minecraft:dragon_fireball,limit=1] at @s run data modify entity @s Motion set value [0.0d,-0.1d,0.0d]