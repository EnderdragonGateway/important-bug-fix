Minecraft: important bug fix
Type: Fabric mixin; 
Develope version: 26.1.2
Developer: Primitive Enderdragon (Enderdragon Gateway)

Project Contained: 项目包含
1. "Fix Attribute Swapping: MC-28289, MC-272517 and ItemStack Problem",
修复属性交换：MC-28289, MC-272517和物品异同的判定问题
2. "Fix Dragon y Velocity So Slow: MC-197201, MC271336, MC-272431",
修复龙y速度过慢的问题：MC-197201, MC271336, MC-272431
3. "Fix Attribute Limit: Armor 30->100(>=100 always get 80% damage reduce from armor), Toughness 20->1024",
修复属性上限限制：护甲值30调为100（>=100盔甲值总是减伤80%），护甲韧性20调为1024
4. "Fix Shield Knockback: MC-147694, MC-182638",
修复盾反弹击退问题：MC-147694, MC-182638
5. "Dragon Breath Cloud from Fireball Similar to Bedrock Edition",
龙火球产生的龙息云变化方式同步基岩版
6. "Void No Hurt for Creative and Spectate Player, Similar to Bedrock Edition",
虚空不再伤害创造模式和旁观者模式的玩家，同步基岩版
7. "Show Player Own Nametag for Datapack Display"
展示玩家自己的名字标签，方便数据包显示内容
8. "Display 1-255 Level for Enchantments and Effects Correctly"
能够正确以数字显示附魔和药水1-255等级

Note: 注意事项
1. Attribute Swapping Fix by TreeOfSelf has some problems, sometimes item get updated to wrong attribute modifiers.
So I rewrite a new type of mixin code to fix this bug almost completely. Now my fix works like that in PaperMC.
TreeOfSelf的Attribute Swapping Fix有问题，有时物品会更新到错误的属性修饰符上。
所以我重写了mixin代码，基本解决了这些问题，现在修复方案和PaperMC的效果相同。

Refrence: 参考项目
1. Attribute Swapping Fix - TreeOfSelf
2. Who am I - Foksha
