
execute at @s store result score @s YPos run data get entity @s Pos[1] 1000
execute at @s store result score @s YVel run data get entity @s Motion[1] 1000
execute if score @s YVel matches 1000.. run scoreboard players set @s YVel 1000
execute if score @s YVel matches ..-1000 run scoreboard players set @s YVel -1000
execute run scoreboard players operation @s YVel *= Speed Temp
execute store result entity @s Pos[1] double 0.001 run scoreboard players operation @s YPos += @s YVel
