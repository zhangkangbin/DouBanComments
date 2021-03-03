package zkb.douban.service;

import okhttp3.*
import java.io.IOException

/**
 *
 * 描述
 * @author:zhangkb
 * Date:2021/3/3
 */
class CommentsContent {

    companion object {
        private val client = OkHttpClient()
        private val list = mutableListOf<String>()
        private var index = 0
        fun getListText(): String {

            if (list.isNullOrEmpty()) {
                list.add("房子几时有？把酒问青天。")
                list.add("君家何处住？我想租福田。")
                list.add("发帖暂借问，或恐是同乡")
                list.add("家临鉴江水，同吃生蚝大")
                list.add("大小不相识，有空回个帖")
                list.add("人生如梦，我投入的却是真情\n" + "\n" + "——汪曾祺")
                list.add("无差异曲线 ：无论是一瓶可乐+2个辣条，或者三个可乐，还是2个可乐一个辣条。数量可能不同，但效用都是一样的。")
                list.add("一个熟悉而陌生的故事")
                list.add("小葱和啊基不久后便要举行婚礼，还邀请了小姜，小油，还有小豪等")
                list.add("他们在高压村的教堂举行婚礼,村如其名，压强很高。")
                list.add("本来土豆也想去参加婚礼的，结果被大佬拒绝了。")
                list.add("其实土豆暗恋啊吉很久了，一直想买通我，让他参加婚礼。具体他想在婚礼上面做什么这个我就不得而知了。")
                list.add("刚刚作为司仪，由他按下了婚礼的start键。")
                list.add("随着一声几声钟响，婚礼正式开始。")
                list.add("邓邓.....邓邓邓，邓，邓邓")
                list.add("刚刚还身兼多职，撒花的也是他，花是他从小葱哪里借来的，待会要捡起来，还回去。")
                list.add("婚礼仪式结束后，他们推开门，那一瞬间，外面烟雾缭绕，香味扑鼻。")
                list.add("原来是四名刺客，他们早早就守住教堂门口了，还劫持着小盐")
                list.add("四名刺客都拿着双刀，他们与刺客博杀了不久后，终究还是全军覆灭，刺客们舔了一下手中的刀，转过身，慢慢离去....。")
                list.add("后人为了缅怀他们英勇奋战，给他们起了一个名字，叫做:洋葱炖鸡")
                list.add("第一季完结！")
                list.add("the end!")
            }
            val tempIndex = index++
            if (tempIndex >=list.size - 1) {
               // index = 0
                return getApiSentence()
            }
            return list[tempIndex]
        }


        private fun getApiSentence(): String {
             var sentence="";
            val request = Request.Builder()
                .url("https://abc.mcloc.cn/abc/api/words/")
                .build();

            client.newCall(request).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    sentence= e.message.toString()
                }

                override fun onResponse(call: Call, response: Response) {
                    sentence= response.body?.string().toString()
                }
            })

             //休眠三秒等待api获取句子
             Thread.sleep(3000)

            if(sentence.isEmpty()){
                return getSentence();
            }

            return sentence;

        }

        /**
         * randoms a sentence
         */
        private fun getSentence():String{

            if(list.isNullOrEmpty()){
                return "本来无一物，何处惹尘埃。"
            }
            val randoms = (0 until list.size).random()

            return list[randoms]
        }

    }
}
