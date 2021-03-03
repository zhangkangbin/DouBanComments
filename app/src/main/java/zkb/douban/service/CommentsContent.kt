package zkb.douban.service;
/**
  *
  * 描述
  * @author:zhangkb
  * Date:2021/3/3
 */
 class CommentsContent {

     companion object{

         fun getListText(){

             val list= mutableListOf<String>()
             list.add("房子几时有？把酒问青天。")
             list.add("君家何处住？我想租福田。")
             list.add("发帖暂借问，或恐是同乡")
             list.add("家临鉴江水，同吃生蚝大")
             list.add("大小不相识，有空回个帖")
             list.add("人生如梦，我投入的却是真情\n" + "\n" + "——汪曾祺")


         }
     }
}
