package com.lazyxu.film.model.entity

import android.text.TextUtils

import java.io.Serializable

/**
 * @author jingbin
 */
class FilmItemEntity : Serializable {


    /**
     * NearestCinemaCount : 24
     * NearestDay : 1557388800
     * NearestShowtimeCount : 27
     * aN1 : 瑞安·雷诺兹
     * aN2 : 贾斯提斯·史密斯
     * actors : 瑞安·雷诺兹 / 贾斯提斯·史密斯 / 凯瑟琳·纽顿 / 雷佳音
     * cC : 50
     * commonSpecial : 萌贱皮卡丘开启宝可梦世界
     * d : 104
     * dN : 罗伯·莱特曼
     * def : 0
     * id : 235701
     * img : http://img5.mtime.cn/mt/2019/05/06/105806.73235069_1280X720X2.jpg
     * is3D : true
     * isDMAX : true
     * isFilter : false
     * isHasTrailer : true
     * isHot : false
     * isIMAX : false
     * isIMAX3D : true
     * isNew : false
     * isTicket : true
     * m :
     * movieId : 235701
     * movieType : 动作 / 冒险 / 喜剧
     * p : ["动作冒险喜剧"]
     * preferentialFlag : false
     * r : 7.1
     * rc : 0
     * rd : 20190510
     * rsC : 0
     * sC : 1144
     * t : 大侦探皮卡丘
     * tCn : 大侦探皮卡丘
     * tEn : Pokémon Detective Pikachu
     * ua : -1
     * versions : [{"enum":2,"version":"3D"},{"enum":4,"version":"IMAX3D"},{"enum":6,"version":"中国巨幕"}]
     * wantedCount : 2161
     * year : 2019
     */

    var aN1: String? = null
    var aN2: String? = null
    var actors: String? = null
    var commonSpecial: String? = null
    var d: String? = null
    var dN: String? = null
    var id: Int = 0
    var img: String? = null
    var isIs3D: Boolean = false
    var isIsDMAX: Boolean = false
    var isIsHot: Boolean = false
    var isIsIMAX: Boolean = false
    var isIsIMAX3D: Boolean = false
    var isIsNew: Boolean = false
    var movieId: Int = 0
    var movieType: String? = null
    // 制片国家
    var locationName: String? = null
        get() = if (!TextUtils.isEmpty(field)) {
            "制片国家：" + field!!
        } else {
            ""
        }
    var r: Double = 0.toDouble()
    var rd: String? = null
    var sc: Int = 0
    var t: String? = null
    var tCn: String? = null
    var tEn: String? = null
    var wantedCount: Int = 0
    var year: String? = null
    var versions: List<VersionsBean>? = null

    class VersionsBean : Serializable {
        /**
         * enum : 2
         * version : 3D
         */

        var version: String? = null
    }

    override fun toString(): String {
        return "FilmItemEntity(aN1=$aN1, aN2=$aN2, actors=$actors, commonSpecial=$commonSpecial, d=$d, dN=$dN, id=$id, img=$img, isIs3D=$isIs3D, isIsDMAX=$isIsDMAX, isIsHot=$isIsHot, isIsIMAX=$isIsIMAX, isIsIMAX3D=$isIsIMAX3D, isIsNew=$isIsNew, movieId=$movieId, movieType=$movieType, r=$r, rd=$rd, sc=$sc, t=$t, tCn=$tCn, tEn=$tEn, wantedCount=$wantedCount, year=$year, versions=$versions)"
    }
}
