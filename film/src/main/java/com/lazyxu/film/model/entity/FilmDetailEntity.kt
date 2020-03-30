package com.lazyxu.film.model.entity

import android.text.TextUtils

class FilmDetailEntity {


    /**
     * code : 1
     * model : {"advertisement":{"advList":[{"advTag":"广告","endDate":1577721599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1546272000,"tag":"商城黑白潮T+商城脑洞打开创意周边","type":"203","typeName":"影片详情页banner2","url":"https://static4da.mtime.cn/feature/mobile/banner/2019/0311/hvtnd750210.html"}],"count":1,"error":"","success":true},"basic":{"actors":[{"actorId":912602,"img":"http://img31.mtime.cn/ph/2014/03/15/134919.70417685_1280X720X2.jpg","name":"小罗伯特·唐尼","nameEn":"Robert Downey Jr.","roleImg":"","roleName":"托尼·斯塔克 / 钢铁侠"},{"actorId":911885,"img":"http://img5.mtime.cn/ph/2018/03/09/102541.67004197_1280X720X2.jpg","name":"克里斯·埃文斯","nameEn":"Chris Evans","roleImg":"","roleName":"史蒂夫·罗杰斯 / 美国队长"},{"actorId":1425372,"img":"http://img31.mtime.cn/ph/2014/03/16/155735.64569449_1280X720X2.jpg","name":"克里斯·海姆斯沃斯","nameEn":"Chris Hemsworth","roleImg":"","roleName":"雷神索尔"},{"actorId":914053,"img":"http://img31.mtime.cn/ph/2014/06/03/103206.78345019_1280X720X2.jpg","name":"乔什·布洛林","nameEn":"Josh Brolin","roleImg":"","roleName":"灭霸"},{"actorId":911751,"img":"http://img31.mtime.cn/ph/2014/03/14/152327.29309922_1280X720X2.jpg","name":"斯嘉丽·约翰逊","nameEn":"Scarlett Johansson","roleImg":"","roleName":"娜塔莎·罗曼诺夫 / 黑寡妇"},{"actorId":913614,"img":"http://img31.mtime.cn/ph/2014/10/23/142321.50900766_1280X720X2.jpg","name":"马克·鲁法洛","nameEn":"Mark Ruffalo","roleImg":"","roleName":"布鲁斯·班纳/绿巨人"},{"actorId":913492,"img":"http://img31.mtime.cn/ph/2014/03/16/164051.53193916_1280X720X2.jpg","name":"杰瑞米·雷纳","nameEn":"Jeremy Renner","roleImg":"","roleName":"鹰眼"},{"actorId":921397,"img":"http://img31.mtime.cn/ph/2015/04/06/115016.13160306_1280X720X2.jpg","name":"保罗·路德","nameEn":"Paul Rudd","roleImg":"","roleName":"蚁人"},{"actorId":1426693,"img":"http://img31.mtime.cn/ph/2014/04/29/151443.48684426_1280X720X2.jpg","name":"凯伦·吉兰","nameEn":"Karen Gillan","roleImg":"","roleName":"星云"},{"actorId":920630,"img":"http://img5.mtime.cn/ph/2016/11/29/093942.38171081_1280X720X2.jpg","name":"唐·钱德尔","nameEn":"Don Cheadle","roleImg":"","roleName":"战争机器"},{"actorId":913695,"img":"http://img31.mtime.cn/ph/2014/03/16/161323.55642433_1280X720X2.jpg","name":"布莱德利·库珀","nameEn":"Bradley Cooper","roleImg":"","roleName":"火箭"},{"actorId":973166,"img":"http://img31.mtime.cn/ph/2016/03/03/151713.83682128_1280X720X2.jpg","name":"布丽·拉尔森","nameEn":"Brie Larson","roleImg":"","roleName":"惊奇队长"},{"actorId":913516,"img":"http://img31.mtime.cn/ph/2014/03/14/153218.69564396_1280X720X2.jpg","name":"佐伊·索尔达娜","nameEn":"Zoe Saldana","roleImg":"","roleName":"卡魔拉"},{"actorId":919246,"img":"http://img31.mtime.cn/ph/2014/03/14/181606.68900757_1280X720X2.jpg","name":"格温妮丝·帕特洛","nameEn":"Gwyneth Paltrow","roleImg":"","roleName":"小辣椒"},{"actorId":2373349,"img":"http://img5.mtime.cn/ph/2019/04/25/114614.54906247_1280X720X2.jpg","name":"亚历山德拉·蕾切尔·拉贝","nameEn":"Alexandra Rachael Rabe","roleImg":"","roleName":"摩根·斯塔克"},{"actorId":1191793,"img":"http://img31.mtime.cn/ph/2014/02/22/211920.69171612_1280X720X2.jpg","name":"泰莎·汤普森","nameEn":"Tessa Thompson","roleImg":"","roleName":"女武神"},{"actorId":1796400,"img":"http://img5.mtime.cn/ph/2018/01/16/191727.80274844_1280X720X2.jpg","name":"汤姆·赫兰德","nameEn":"Tom Holland","roleImg":"","roleName":"彼得·帕克 / 蜘蛛侠"},{"actorId":969761,"img":"http://img31.mtime.cn/ph/2014/10/04/161031.79193450_1280X720X2.jpg","name":"蕾妮·罗素","nameEn":"Rene Russo","roleImg":"","roleName":"雷神母亲"},{"actorId":1117773,"img":"http://img31.mtime.cn/ph/2014/03/14/095058.62924168_1280X720X2.jpg","name":"汤姆·希德勒斯顿","nameEn":"Tom Hiddleston","roleImg":"","roleName":"洛基"},{"actorId":1806378,"img":"http://img31.mtime.cn/ph/2014/04/15/103438.77476209_1280X720X2.jpg","name":"伊丽莎白·奥尔森","nameEn":"Elizabeth Olsen","roleImg":"","roleName":"旺达·马克西莫夫 / 红女巫"}],"award":{"awardList":[],"totalNominateAward":0,"totalWinAward":0},"bigImage":"","commentSpecial":"超级英雄们共谋大计战灭霸","community":{},"director":{"directorId":903229,"img":"http://img31.mtime.cn/ph/2014/03/14/152324.64956342_1280X720X2.jpg","name":"安东尼·罗素","nameEn":"Anthony Russo"},"festivals":[],"hotRanking":-1,"img":"http://img5.mtime.cn/mt/2019/03/29/095608.66203322_1280X720X2.jpg","is3D":true,"isDMAX":true,"isEggHunt":false,"isFilter":false,"isIMAX":false,"isIMAX3D":true,"isTicket":true,"message":"该操作将清除您对该片的评分！是否确认？","mins":"181分钟","movieId":218090,"movieStatus":1,"name":"复仇者联盟4：终局之战","nameEn":"Avengers: Endgame","overallRating":8.3,"personCount":321,"quizGame":{},"releaseArea":"中国","releaseDate":"20190424","sensitiveStatus":false,"showCinemaCount":66,"showDay":1557388800,"showtimeCount":1042,"stageImg":{"count":492,"list":[{"imgId":7530837,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095718.20503556_1280X720X2.jpg"},{"imgId":7530838,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095719.81293973_1280X720X2.jpg"},{"imgId":7530839,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095720.56498166_1280X720X2.jpg"},{"imgId":7530840,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095722.99339034_1280X720X2.jpg"}]},"story":"《复仇者联盟3：无限战争》的毁灭性事件过后，宇宙由于疯狂泰坦灭霸的行动而变得满目疮痍。无论前方将遭遇怎样的后果，复仇者联盟都必须在剩余盟友的帮助下再一次集结，以逆转灭霸的所作所为，彻底恢复宇宙的秩序。","style":{"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""},"totalNominateAward":0,"totalWinAward":0,"type":["动作","冒险","奇幻","科幻"],"url":"https://movie.mtime.com/218090/","video":{"count":51,"hightUrl":"https://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995.mp4","img":"http://img5.mtime.cn/mg/2019/03/14/223956.68342218_235X132X4.jpg","title":"复仇者联盟4 剧场版中文预告","url":"https://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995_480.mp4","videoId":74055,"videoSourceType":1}},"boxOffice":{"movieId":218090,"ranking":2,"todayBox":624073437,"todayBoxDes":"624.07","todayBoxDesUnit":"今日实时(万)","totalBox":404496826397,"totalBoxDes":"40.45","totalBoxUnit":"累计票房(亿)"},"live":{"count":2,"img":"http://img5.mtime.cn/mg/2019/04/17/142007.89325457.jpg","liveId":940,"playNumTag":"106.2万次播放","playTag":"","status":4,"title":"《复仇者联盟4》影迷盛典"},"playState":"1","playlist":[],"related":{"goodsCount":21,"goodsList":[{"background":"","goodsId":107042,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/107042/","iconText":"","image":"http://img5.mtime.cn/mg/2018/04/18/184415.72879699_294X294X4.jpg","longName":"复仇者联盟3 经典漫画复古马克杯","marketPrice":0,"marketPriceFormat":"0.00","minSalePrice":6900,"minSalePriceFormat":"69.00","name":"复联3 经典漫画复古马克杯"},{"background":"#25ACBD","goodsId":107060,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/107060/","iconText":"新品","image":"http://img5.mtime.cn/mg/2019/04/19/163308.19659571_294X294X4.jpg","longName":"复仇者联盟3 漫威LOGO长带棒球帽","marketPrice":6900,"marketPriceFormat":"69.00","minSalePrice":6900,"minSalePriceFormat":"69.00","name":"复联3 漫威LOGO长带棒球帽"},{"background":"#25ACBD","goodsId":108084,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/108084/","iconText":"新品","image":"http://img5.mtime.cn/mg/2019/04/17/113531.40938217_294X294X4.jpg","longName":"复联4英雄人物合集潮款T恤","marketPrice":0,"marketPriceFormat":"0.00","minSalePrice":10900,"minSalePriceFormat":"109.00","name":"复联4英雄人物合集潮款T恤"}],"relateId":0,"relatedUrl":"https://mall-wv.mtime.cn/?mid=218090&relatedNativeType=1&utm_source=app_movie_btn_more#!/commerce/list/","type":0}}
     * msg : 成功
     * showMsg :
     */

    var code: String? = null
    var data: FilmDetailDataBean? = null
    var msg: String? = null

    class FilmDetailDataBean {
        /**
         * advertisement : {"advList":[{"advTag":"广告","endDate":1577721599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1546272000,"tag":"商城黑白潮T+商城脑洞打开创意周边","type":"203","typeName":"影片详情页banner2","url":"https://static4da.mtime.cn/feature/mobile/banner/2019/0311/hvtnd750210.html"}],"count":1,"error":"","success":true}
         * basic : {"actors":[{"actorId":912602,"img":"http://img31.mtime.cn/ph/2014/03/15/134919.70417685_1280X720X2.jpg","name":"小罗伯特·唐尼","nameEn":"Robert Downey Jr.","roleImg":"","roleName":"托尼·斯塔克 / 钢铁侠"},{"actorId":911885,"img":"http://img5.mtime.cn/ph/2018/03/09/102541.67004197_1280X720X2.jpg","name":"克里斯·埃文斯","nameEn":"Chris Evans","roleImg":"","roleName":"史蒂夫·罗杰斯 / 美国队长"},{"actorId":1425372,"img":"http://img31.mtime.cn/ph/2014/03/16/155735.64569449_1280X720X2.jpg","name":"克里斯·海姆斯沃斯","nameEn":"Chris Hemsworth","roleImg":"","roleName":"雷神索尔"},{"actorId":914053,"img":"http://img31.mtime.cn/ph/2014/06/03/103206.78345019_1280X720X2.jpg","name":"乔什·布洛林","nameEn":"Josh Brolin","roleImg":"","roleName":"灭霸"},{"actorId":911751,"img":"http://img31.mtime.cn/ph/2014/03/14/152327.29309922_1280X720X2.jpg","name":"斯嘉丽·约翰逊","nameEn":"Scarlett Johansson","roleImg":"","roleName":"娜塔莎·罗曼诺夫 / 黑寡妇"},{"actorId":913614,"img":"http://img31.mtime.cn/ph/2014/10/23/142321.50900766_1280X720X2.jpg","name":"马克·鲁法洛","nameEn":"Mark Ruffalo","roleImg":"","roleName":"布鲁斯·班纳/绿巨人"},{"actorId":913492,"img":"http://img31.mtime.cn/ph/2014/03/16/164051.53193916_1280X720X2.jpg","name":"杰瑞米·雷纳","nameEn":"Jeremy Renner","roleImg":"","roleName":"鹰眼"},{"actorId":921397,"img":"http://img31.mtime.cn/ph/2015/04/06/115016.13160306_1280X720X2.jpg","name":"保罗·路德","nameEn":"Paul Rudd","roleImg":"","roleName":"蚁人"},{"actorId":1426693,"img":"http://img31.mtime.cn/ph/2014/04/29/151443.48684426_1280X720X2.jpg","name":"凯伦·吉兰","nameEn":"Karen Gillan","roleImg":"","roleName":"星云"},{"actorId":920630,"img":"http://img5.mtime.cn/ph/2016/11/29/093942.38171081_1280X720X2.jpg","name":"唐·钱德尔","nameEn":"Don Cheadle","roleImg":"","roleName":"战争机器"},{"actorId":913695,"img":"http://img31.mtime.cn/ph/2014/03/16/161323.55642433_1280X720X2.jpg","name":"布莱德利·库珀","nameEn":"Bradley Cooper","roleImg":"","roleName":"火箭"},{"actorId":973166,"img":"http://img31.mtime.cn/ph/2016/03/03/151713.83682128_1280X720X2.jpg","name":"布丽·拉尔森","nameEn":"Brie Larson","roleImg":"","roleName":"惊奇队长"},{"actorId":913516,"img":"http://img31.mtime.cn/ph/2014/03/14/153218.69564396_1280X720X2.jpg","name":"佐伊·索尔达娜","nameEn":"Zoe Saldana","roleImg":"","roleName":"卡魔拉"},{"actorId":919246,"img":"http://img31.mtime.cn/ph/2014/03/14/181606.68900757_1280X720X2.jpg","name":"格温妮丝·帕特洛","nameEn":"Gwyneth Paltrow","roleImg":"","roleName":"小辣椒"},{"actorId":2373349,"img":"http://img5.mtime.cn/ph/2019/04/25/114614.54906247_1280X720X2.jpg","name":"亚历山德拉·蕾切尔·拉贝","nameEn":"Alexandra Rachael Rabe","roleImg":"","roleName":"摩根·斯塔克"},{"actorId":1191793,"img":"http://img31.mtime.cn/ph/2014/02/22/211920.69171612_1280X720X2.jpg","name":"泰莎·汤普森","nameEn":"Tessa Thompson","roleImg":"","roleName":"女武神"},{"actorId":1796400,"img":"http://img5.mtime.cn/ph/2018/01/16/191727.80274844_1280X720X2.jpg","name":"汤姆·赫兰德","nameEn":"Tom Holland","roleImg":"","roleName":"彼得·帕克 / 蜘蛛侠"},{"actorId":969761,"img":"http://img31.mtime.cn/ph/2014/10/04/161031.79193450_1280X720X2.jpg","name":"蕾妮·罗素","nameEn":"Rene Russo","roleImg":"","roleName":"雷神母亲"},{"actorId":1117773,"img":"http://img31.mtime.cn/ph/2014/03/14/095058.62924168_1280X720X2.jpg","name":"汤姆·希德勒斯顿","nameEn":"Tom Hiddleston","roleImg":"","roleName":"洛基"},{"actorId":1806378,"img":"http://img31.mtime.cn/ph/2014/04/15/103438.77476209_1280X720X2.jpg","name":"伊丽莎白·奥尔森","nameEn":"Elizabeth Olsen","roleImg":"","roleName":"旺达·马克西莫夫 / 红女巫"}],"award":{"awardList":[],"totalNominateAward":0,"totalWinAward":0},"bigImage":"","commentSpecial":"超级英雄们共谋大计战灭霸","community":{},"director":{"directorId":903229,"img":"http://img31.mtime.cn/ph/2014/03/14/152324.64956342_1280X720X2.jpg","name":"安东尼·罗素","nameEn":"Anthony Russo"},"festivals":[],"hotRanking":-1,"img":"http://img5.mtime.cn/mt/2019/03/29/095608.66203322_1280X720X2.jpg","is3D":true,"isDMAX":true,"isEggHunt":false,"isFilter":false,"isIMAX":false,"isIMAX3D":true,"isTicket":true,"message":"该操作将清除您对该片的评分！是否确认？","mins":"181分钟","movieId":218090,"movieStatus":1,"name":"复仇者联盟4：终局之战","nameEn":"Avengers: Endgame","overallRating":8.3,"personCount":321,"quizGame":{},"releaseArea":"中国","releaseDate":"20190424","sensitiveStatus":false,"showCinemaCount":66,"showDay":1557388800,"showtimeCount":1042,"stageImg":{"count":492,"list":[{"imgId":7530837,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095718.20503556_1280X720X2.jpg"},{"imgId":7530838,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095719.81293973_1280X720X2.jpg"},{"imgId":7530839,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095720.56498166_1280X720X2.jpg"},{"imgId":7530840,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095722.99339034_1280X720X2.jpg"}]},"story":"《复仇者联盟3：无限战争》的毁灭性事件过后，宇宙由于疯狂泰坦灭霸的行动而变得满目疮痍。无论前方将遭遇怎样的后果，复仇者联盟都必须在剩余盟友的帮助下再一次集结，以逆转灭霸的所作所为，彻底恢复宇宙的秩序。","style":{"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""},"totalNominateAward":0,"totalWinAward":0,"type":["动作","冒险","奇幻","科幻"],"url":"https://movie.mtime.com/218090/","video":{"count":51,"hightUrl":"https://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995.mp4","img":"http://img5.mtime.cn/mg/2019/03/14/223956.68342218_235X132X4.jpg","title":"复仇者联盟4 剧场版中文预告","url":"https://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995_480.mp4","videoId":74055,"videoSourceType":1}}
         * boxOffice : {"movieId":218090,"ranking":2,"todayBox":624073437,"todayBoxDes":"624.07","todayBoxDesUnit":"今日实时(万)","totalBox":404496826397,"totalBoxDes":"40.45","totalBoxUnit":"累计票房(亿)"}
         * live : {"count":2,"img":"http://img5.mtime.cn/mg/2019/04/17/142007.89325457.jpg","liveId":940,"playNumTag":"106.2万次播放","playTag":"","status":4,"title":"《复仇者联盟4》影迷盛典"}
         * playState : 1
         * playlist : []
         * related : {"goodsCount":21,"goodsList":[{"background":"","goodsId":107042,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/107042/","iconText":"","image":"http://img5.mtime.cn/mg/2018/04/18/184415.72879699_294X294X4.jpg","longName":"复仇者联盟3 经典漫画复古马克杯","marketPrice":0,"marketPriceFormat":"0.00","minSalePrice":6900,"minSalePriceFormat":"69.00","name":"复联3 经典漫画复古马克杯"},{"background":"#25ACBD","goodsId":107060,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/107060/","iconText":"新品","image":"http://img5.mtime.cn/mg/2019/04/19/163308.19659571_294X294X4.jpg","longName":"复仇者联盟3 漫威LOGO长带棒球帽","marketPrice":6900,"marketPriceFormat":"69.00","minSalePrice":6900,"minSalePriceFormat":"69.00","name":"复联3 漫威LOGO长带棒球帽"},{"background":"#25ACBD","goodsId":108084,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/108084/","iconText":"新品","image":"http://img5.mtime.cn/mg/2019/04/17/113531.40938217_294X294X4.jpg","longName":"复联4英雄人物合集潮款T恤","marketPrice":0,"marketPriceFormat":"0.00","minSalePrice":10900,"minSalePriceFormat":"109.00","name":"复联4英雄人物合集潮款T恤"}],"relateId":0,"relatedUrl":"https://mall-wv.mtime.cn/?mid=218090&relatedNativeType=1&utm_source=app_movie_btn_more#!/commerce/list/","type":0}
         */

        var basic: BasicBean? = null
        var boxOffice: BoxOfficeBean? = null
        var playState: String? = null
        var related: RelatedBean? = null


        class BasicBean {
            /**
             * actors : [{"actorId":912602,"img":"http://img31.mtime.cn/ph/2014/03/15/134919.70417685_1280X720X2.jpg","name":"小罗伯特·唐尼","nameEn":"Robert Downey Jr.","roleImg":"","roleName":"托尼·斯塔克 / 钢铁侠"},{"actorId":911885,"img":"http://img5.mtime.cn/ph/2018/03/09/102541.67004197_1280X720X2.jpg","name":"克里斯·埃文斯","nameEn":"Chris Evans","roleImg":"","roleName":"史蒂夫·罗杰斯 / 美国队长"},{"actorId":1425372,"img":"http://img31.mtime.cn/ph/2014/03/16/155735.64569449_1280X720X2.jpg","name":"克里斯·海姆斯沃斯","nameEn":"Chris Hemsworth","roleImg":"","roleName":"雷神索尔"},{"actorId":914053,"img":"http://img31.mtime.cn/ph/2014/06/03/103206.78345019_1280X720X2.jpg","name":"乔什·布洛林","nameEn":"Josh Brolin","roleImg":"","roleName":"灭霸"},{"actorId":911751,"img":"http://img31.mtime.cn/ph/2014/03/14/152327.29309922_1280X720X2.jpg","name":"斯嘉丽·约翰逊","nameEn":"Scarlett Johansson","roleImg":"","roleName":"娜塔莎·罗曼诺夫 / 黑寡妇"},{"actorId":913614,"img":"http://img31.mtime.cn/ph/2014/10/23/142321.50900766_1280X720X2.jpg","name":"马克·鲁法洛","nameEn":"Mark Ruffalo","roleImg":"","roleName":"布鲁斯·班纳/绿巨人"},{"actorId":913492,"img":"http://img31.mtime.cn/ph/2014/03/16/164051.53193916_1280X720X2.jpg","name":"杰瑞米·雷纳","nameEn":"Jeremy Renner","roleImg":"","roleName":"鹰眼"},{"actorId":921397,"img":"http://img31.mtime.cn/ph/2015/04/06/115016.13160306_1280X720X2.jpg","name":"保罗·路德","nameEn":"Paul Rudd","roleImg":"","roleName":"蚁人"},{"actorId":1426693,"img":"http://img31.mtime.cn/ph/2014/04/29/151443.48684426_1280X720X2.jpg","name":"凯伦·吉兰","nameEn":"Karen Gillan","roleImg":"","roleName":"星云"},{"actorId":920630,"img":"http://img5.mtime.cn/ph/2016/11/29/093942.38171081_1280X720X2.jpg","name":"唐·钱德尔","nameEn":"Don Cheadle","roleImg":"","roleName":"战争机器"},{"actorId":913695,"img":"http://img31.mtime.cn/ph/2014/03/16/161323.55642433_1280X720X2.jpg","name":"布莱德利·库珀","nameEn":"Bradley Cooper","roleImg":"","roleName":"火箭"},{"actorId":973166,"img":"http://img31.mtime.cn/ph/2016/03/03/151713.83682128_1280X720X2.jpg","name":"布丽·拉尔森","nameEn":"Brie Larson","roleImg":"","roleName":"惊奇队长"},{"actorId":913516,"img":"http://img31.mtime.cn/ph/2014/03/14/153218.69564396_1280X720X2.jpg","name":"佐伊·索尔达娜","nameEn":"Zoe Saldana","roleImg":"","roleName":"卡魔拉"},{"actorId":919246,"img":"http://img31.mtime.cn/ph/2014/03/14/181606.68900757_1280X720X2.jpg","name":"格温妮丝·帕特洛","nameEn":"Gwyneth Paltrow","roleImg":"","roleName":"小辣椒"},{"actorId":2373349,"img":"http://img5.mtime.cn/ph/2019/04/25/114614.54906247_1280X720X2.jpg","name":"亚历山德拉·蕾切尔·拉贝","nameEn":"Alexandra Rachael Rabe","roleImg":"","roleName":"摩根·斯塔克"},{"actorId":1191793,"img":"http://img31.mtime.cn/ph/2014/02/22/211920.69171612_1280X720X2.jpg","name":"泰莎·汤普森","nameEn":"Tessa Thompson","roleImg":"","roleName":"女武神"},{"actorId":1796400,"img":"http://img5.mtime.cn/ph/2018/01/16/191727.80274844_1280X720X2.jpg","name":"汤姆·赫兰德","nameEn":"Tom Holland","roleImg":"","roleName":"彼得·帕克 / 蜘蛛侠"},{"actorId":969761,"img":"http://img31.mtime.cn/ph/2014/10/04/161031.79193450_1280X720X2.jpg","name":"蕾妮·罗素","nameEn":"Rene Russo","roleImg":"","roleName":"雷神母亲"},{"actorId":1117773,"img":"http://img31.mtime.cn/ph/2014/03/14/095058.62924168_1280X720X2.jpg","name":"汤姆·希德勒斯顿","nameEn":"Tom Hiddleston","roleImg":"","roleName":"洛基"},{"actorId":1806378,"img":"http://img31.mtime.cn/ph/2014/04/15/103438.77476209_1280X720X2.jpg","name":"伊丽莎白·奥尔森","nameEn":"Elizabeth Olsen","roleImg":"","roleName":"旺达·马克西莫夫 / 红女巫"}]
             * award : {"awardList":[],"totalNominateAward":0,"totalWinAward":0}
             * bigImage :
             * commentSpecial : 超级英雄们共谋大计战灭霸
             * community : {}
             * director : {"directorId":903229,"img":"http://img31.mtime.cn/ph/2014/03/14/152324.64956342_1280X720X2.jpg","name":"安东尼·罗素","nameEn":"Anthony Russo"}
             * festivals : []
             * hotRanking : -1
             * img : http://img5.mtime.cn/mt/2019/03/29/095608.66203322_1280X720X2.jpg
             * is3D : true
             * isDMAX : true
             * isEggHunt : false
             * isFilter : false
             * isIMAX : false
             * isIMAX3D : true
             * isTicket : true
             * message : 该操作将清除您对该片的评分！是否确认？
             * mins : 181分钟
             * movieId : 218090
             * movieStatus : 1
             * name : 复仇者联盟4：终局之战
             * nameEn : Avengers: Endgame
             * overallRating : 8.3
             * personCount : 321
             * quizGame : {}
             * releaseArea : 中国
             * releaseDate : 20190424
             * sensitiveStatus : false
             * showCinemaCount : 66
             * showDay : 1557388800
             * showtimeCount : 1042
             * stageImg : {"count":492,"list":[{"imgId":7530837,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095718.20503556_1280X720X2.jpg"},{"imgId":7530838,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095719.81293973_1280X720X2.jpg"},{"imgId":7530839,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095720.56498166_1280X720X2.jpg"},{"imgId":7530840,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095722.99339034_1280X720X2.jpg"}]}
             * story : 《复仇者联盟3：无限战争》的毁灭性事件过后，宇宙由于疯狂泰坦灭霸的行动而变得满目疮痍。无论前方将遭遇怎样的后果，复仇者联盟都必须在剩余盟友的帮助下再一次集结，以逆转灭霸的所作所为，彻底恢复宇宙的秩序。
             * style : {"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""}
             * totalNominateAward : 0
             * totalWinAward : 0
             * type : ["动作","冒险","奇幻","科幻"]
             * url : https://movie.mtime.com/218090/
             * video : {"count":51,"hightUrl":"https://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995.mp4","img":"http://img5.mtime.cn/mg/2019/03/14/223956.68342218_235X132X4.jpg","title":"复仇者联盟4 剧场版中文预告","url":"https://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995_480.mp4","videoId":74055,"videoSourceType":1}
             */

            var bigImage: String? = null
            var commentSpecial: String? = null
                get() = if (!TextUtils.isEmpty(field)) {
                    "“ $field ”"
                } else {
                    ""
                }
            var director: ActorsBean? = null
            var img: String? = null
            var isIs3D: Boolean = false
            var isIsDMAX: Boolean = false
            var isIsEggHunt: Boolean = false
            var isIsFilter: Boolean = false
            var isIsIMAX: Boolean = false
            var isIsIMAX3D: Boolean = false
            var isIsTicket: Boolean = false
            var message: String? = null
            var mins: String? = null
                get() = if (TextUtils.isEmpty(field)) {
                    "未知"
                } else field
            var movieId: Int = 0
            var name: String? = null
            var nameEn: String? = null
            var overallRating: Double = 0.toDouble()
            var personCount: Int = 0
            var releaseArea: String? = null
            var releaseDate: String? = null
            var isSensitiveStatus: Boolean = false
            var showCinemaCount: Int = 0
            var showtimeCount: Int = 0
            var stageImg: StageImgBean? = null
            var story: String? = null
            var style: StyleBean? = null
            var totalNominateAward: Int = 0
            var totalWinAward: Int = 0
            var url: String? = null
            var video: VideoBean? = null
            var actors: List<ActorsBean>? = null
            var type: List<String>? = null

            class StageImgBean {
                /**
                 * count : 492
                 * list : [{"imgId":7530837,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095718.20503556_1280X720X2.jpg"},{"imgId":7530838,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095719.81293973_1280X720X2.jpg"},{"imgId":7530839,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095720.56498166_1280X720X2.jpg"},{"imgId":7530840,"imgUrl":"http://img5.mtime.cn/pi/2019/03/29/095722.99339034_1280X720X2.jpg"}]
                 */

                var count: Int = 0
                var list: List<ImageListBean>? = null


            }

            class StyleBean {
                /**
                 * isLeadPage : 0
                 * leadImg : https://img2.mtime.cn/mg/.jpg
                 * leadUrl :
                 */

                var isLeadPage: Int = 0
                var leadImg: String? = null
                var leadUrl: String? = null
            }

            class VideoBean {
                /**
                 * count : 51
                 * hightUrl : https://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995.mp4
                 * img : http://img5.mtime.cn/mg/2019/03/14/223956.68342218_235X132X4.jpg
                 * title : 复仇者联盟4 剧场版中文预告
                 * url : https://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995_480.mp4
                 * videoId : 74055
                 * videoSourceType : 1
                 */

                var count: Int = 0
                var hightUrl: String? = null
                var img: String? = null
                    get() {
                        if (!TextUtils.isEmpty(field)) {
                            if (field!!.contains("_")) {
                                val indexOf = field!!.indexOf("_")
                                var endIndex = 0
                                if (field!!.toLowerCase().contains(".jpg")) {
                                    endIndex = field!!.indexOf(".jpg")
                                } else if (field!!.toLowerCase().contains(".png")) {
                                    endIndex = field!!.indexOf(".png")
                                }
                                if (endIndex == 0) {
                                    return field
                                } else {
                                    val substring = field!!.substring(indexOf, endIndex)
                                    return field!!.replace(substring, "")
                                }
                            } else {
                                return field
                            }
                        } else {
                            return ""
                        }
                    }
                var title: String? = null
                var url: String? = null
                var videoId: Int = 0
                var videoSourceType: Int = 0
            }


        }

        class BoxOfficeBean {
            /**
             * movieId : 218090
             * ranking : 2
             * todayBox : 624073437
             * todayBoxDes : 624.07
             * todayBoxDesUnit : 今日实时(万)
             * totalBox : 404496826397
             * totalBoxDes : 40.45
             * totalBoxUnit : 累计票房(亿)
             */

            var movieId: Int = 0
            var ranking: Int = 0
            var todayBox: Long = 0
            var todayBoxDes: String? = null
            var todayBoxDesUnit: String? = null
            var totalBox: Long = 0
            var totalBoxDes: String? = null
            var totalBoxUnit: String? = null
        }


        class RelatedBean {
            /**
             * goodsCount : 21
             * goodsList : [{"background":"","goodsId":107042,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/107042/","iconText":"","image":"http://img5.mtime.cn/mg/2018/04/18/184415.72879699_294X294X4.jpg","longName":"复仇者联盟3 经典漫画复古马克杯","marketPrice":0,"marketPriceFormat":"0.00","minSalePrice":6900,"minSalePriceFormat":"69.00","name":"复联3 经典漫画复古马克杯"},{"background":"#25ACBD","goodsId":107060,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/107060/","iconText":"新品","image":"http://img5.mtime.cn/mg/2019/04/19/163308.19659571_294X294X4.jpg","longName":"复仇者联盟3 漫威LOGO长带棒球帽","marketPrice":6900,"marketPriceFormat":"69.00","minSalePrice":6900,"minSalePriceFormat":"69.00","name":"复联3 漫威LOGO长带棒球帽"},{"background":"#25ACBD","goodsId":108084,"goodsTip":"自营","goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/108084/","iconText":"新品","image":"http://img5.mtime.cn/mg/2019/04/17/113531.40938217_294X294X4.jpg","longName":"复联4英雄人物合集潮款T恤","marketPrice":0,"marketPriceFormat":"0.00","minSalePrice":10900,"minSalePriceFormat":"109.00","name":"复联4英雄人物合集潮款T恤"}]
             * relateId : 0
             * relatedUrl : https://mall-wv.mtime.cn/?mid=218090&relatedNativeType=1&utm_source=app_movie_btn_more#!/commerce/list/
             * type : 0
             */

            var goodsCount: Int = 0
            var relatedUrl: String? = null
            var type: Int = 0
            var goodsList: List<GoodsListBean>? = null

            class GoodsListBean {
                /**
                 * background :
                 * goodsId : 107042
                 * goodsTip : 自营
                 * goodsUrl : https://mall-wv.mtime.cn/#!/commerce/item/107042/
                 * iconText :
                 * image : http://img5.mtime.cn/mg/2018/04/18/184415.72879699_294X294X4.jpg
                 * longName : 复仇者联盟3 经典漫画复古马克杯
                 * marketPrice : 0
                 * marketPriceFormat : 0.00
                 * minSalePrice : 6900
                 * minSalePriceFormat : 69.00
                 * name : 复联3 经典漫画复古马克杯
                 */

                var background: String? = null
                var goodsId: Int = 0
                var goodsTip: String? = null
                var goodsUrl: String? = null
                var iconText: String? = null
                var image: String? = null
                var longName: String? = null
                var marketPriceFormat: String? = null
                var minSalePriceFormat: String? = null
                var name: String? = null
            }
        }
    }

    class ActorsBean {
        /**
         * actorId : 912602
         * img : http://img31.mtime.cn/ph/2014/03/15/134919.70417685_1280X720X2.jpg
         * name : 小罗伯特·唐尼
         * nameEn : Robert Downey Jr.
         * roleImg :
         * roleName : 托尼·斯塔克 / 钢铁侠
         */

        var img: String? = null
        var name: String? = null
        var nameEn: String? = null
        var roleImg: String? = null
        var roleName: String? = null
    }

    class ImageListBean {
        /**
         * imgId : 7530837
         * imgUrl : http://img5.mtime.cn/pi/2019/03/29/095718.20503556_1280X720X2.jpg
         */

        var imgId: Int = 0
        var imgUrl: String? = null
    }
}
