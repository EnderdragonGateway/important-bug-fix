Minecraft: important bug fix

类型 Type: Fabric mixin; 

开发版本 Develope version: 26.1.2

开发者 Developer: Primitive Enderdragon (Enderdragon Gateway)

项目包含 Project Contained: 

1. 修复属性交换：MC-28289, MC-272517和物品异同的判定问题
  "Fix Attribute Swapping: MC-28289, MC-272517 and ItemStack Problem"

2. 修复龙y速度过慢的问题：MC-197201, MC271336, MC-272431
  "Fix Dragon y Velocity So Slow: MC-197201, MC271336, MC-272431"

3. 修复属性上限限制：护甲值30调为100（>=100盔甲值总是减伤80%），护甲韧性20调为1024
  "Fix Attribute Limit: Armor 30->100(>=100 always get 80% damage reduce from armor), Toughness 20->1024"

4. 修复盾反弹击退问题：MC-147694, MC-182638
  "Fix Shield Knockback: MC-147694, MC-182638"

5. 龙火球产生的龙息云变化方式同步基岩版
  "Dragon Breath Cloud from Fireball Similar to Bedrock Edition"

6. 虚空不再伤害创造模式和旁观者模式的玩家，同步基岩版
  "Void No Hurt for Creative and Spectate Player, Similar to Bedrock Edition"

7. 展示玩家自己的名字标签，方便数据包显示内容
  "Show Player Own Nametag for Datapack Display"

8. 能够正确以数字显示附魔和药水1-255等级
  "Display 1-255 Level for Enchantments and Effects Correctly"

注意事项 Note:

1. TreeOfSelf的Attribute Swapping Fix有问题，有时物品会更新到错误的属性修饰符上。
所以我重写了mixin代码，基本解决了这些问题，现在修复方案和PaperMC的效果相同。
  "Attribute Swapping Fix by TreeOfSelf has some problems, sometimes item get updated to wrong attribute modifiers.
So I rewrite a new type of mixin code to fix this bug almost completely. Now my fix works like that in PaperMC."

参考项目 Refrence:

1. Attribute Swapping Fix - TreeOfSelf
2. Who am I - Foksha
