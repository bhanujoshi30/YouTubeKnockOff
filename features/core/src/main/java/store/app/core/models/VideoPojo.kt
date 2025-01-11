package store.app.core.models

import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize


@Parcelize
data class VideoResponse(
    val VideoDetailModel: List<VideoDetailModel>
) : Parcelable

@Parcelize
data class VideoDetailModel(
    val Id:Int,
    val imgUrl: String ,
    var title: String,
    val description: String,
    val logo: String,
    val channelModel: VideoChannelModel,
    val videoModel: VideoModel,
    var isHeader: Boolean =false
) : Parcelable

@Parcelize
data class VideoChannelModel(
    val channelLogo: String,
    val channelTitle: String
) :Parcelable

@Parcelize
data class VideoModel(
    val videoUrl: String,
    var videoTitle: String,
    val commentsList: List<String> = listOf("THis is Tom."," this is jerry.")
):Parcelable

fun getVideoList(): List<VideoDetailModel> {
    val videoResponse: VideoResponse =Gson().fromJson(arrOfList,VideoResponse::class.java)
    videoResponse.VideoDetailModel[0].isHeader=true
    return videoResponse.VideoDetailModel
}

fun getVideoResponse(): VideoResponse {
    val videoResponse: VideoResponse =Gson().fromJson(arrOfList,VideoResponse::class.java)
    videoResponse.VideoDetailModel[0].isHeader=true
    return videoResponse
}

val arrOfList="""{
  "VideoDetailModel": [
    {
       "Id": 1,
      "description": "Big Buck Bunny tells the story of ",
      "videoModel": {
        "videoUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        "videoTitle": "This is Tom Jerry Show"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Cartoon Network"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
      "title": "Big Buck Bunny"
    },
    {
    "Id": 2,
      "description": "The first Blender Open Movie from 2006",
      "videoModel": {
        "videoUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        "videoTitle": "By Blender Foundation"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Pogo Channel"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg",
      "title": "Elephant Dream"
    },
    {
    "Id": 3,
      "description": "HBO GO now works with Chromecast",
      "videoModel": {
        "videoUrl":  "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        "videoTitle": "By Google"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle":"Google inc co."
      },

      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg",
      "title": "For Bigger Blazes"
    },
    {
    "Id": 4,
      "description": "Introducing Chromecast.",
      "videoModel": {
        "videoUrl":  "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
        "videoTitle": "ChromCarst world Video introduction"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "By Blender Foundation"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerEscapes.jpg",
      "title": "For Bigger Escape"
    },
    {
    "Id": 5,
      "description": " The easiest way to enjoy online video and music on your TV",
      "videoModel": {
        "videoUrl":  "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
        "videoTitle": "Harry Potter and Goblet fires"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Wizard world"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerFun.jpg",
      "title": "Harry Potter and Goblet fires"
    },
    {
    "Id": 6,
      "description": " TV—for the times that call for bigger joyrides.",
      "videoModel": {
        "videoUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
        "videoTitle": "Jacky chan titles"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Action Movies"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerJoyrides.jpg",
      "title": "For Bigger Joyrides"
    },
    {
    "Id": 7,
      "description": "Buster's big meltdowns even bigger.",
      "videoModel": {
        "videoUrl":"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
        "videoTitle": "Hollywood action scenes"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Action jaction"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerMeltdowns.jpg",
      "title": "For Bigger Meltdowns"
    },
    {
    "Id": 8,
      "description": "Sintel is an independently produced short film",
      "videoModel": {
        "videoUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
        "videoTitle": "Hollywood cities"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "By Blender Foundation"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/Sintel.jpg",
      "title": "Sintel"
    },
    {
    "Id": 9,
      "description": "Smoking Tire takes the all-new Subaru Outback",
      "videoModel": {
        "videoUrl":"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
        "videoTitle": "Smoking Effects"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Health Foundation"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/SubaruOutbackOnStreetAndDirt.jpg",
      "title": "Subaru Outback On Street And Dirt"
    },
    {
    "Id": 10,
      "description": "Tears of Steel was realized with crowd-funding",
      "videoModel": {
        "videoUrl":"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
        "videoTitle": "Tears of Steel"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Tears of Steel"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/TearsOfSteel.jpg",
      "title": "Tears of Steel"
    },
    {
    "Id": 11,
      "description": "The Smoking Tire heads out to Adams Motorsports",
      "videoModel": {
        "videoUrl":  "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4",
        "videoTitle": "Volkswagen GTI Review"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Volkswagen Cars"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/VolkswagenGTIReview.jpg",
      "title": "Volkswagen GTI Review"
    },
    {
    "Id": 12,
      "description": "The Smoking Tire is going on the 2010 Bullrun Live Rally",
      "videoModel": {
        "videoUrl":   "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
        "videoTitle": "We Are Going On Bullrun Hyundai CArs"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "india on Groww"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/WeAreGoingOnBullrun.jpg",
      "title": "We Are Going On Bullrun"
    },
    {
    "Id": 13,
      "description": "The Smoking Tire meets up with Chris and Jorge ",

      "videoModel": {
        "videoUrl":   "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4",
        "videoTitle": "What care can you get for a grand?"
      },
      "channelModel": {
        "channelLogo": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        "channelTitle": "Action Jaction"
      },
      "imgUrl": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/WhatCarCanYouGetForAGrand.jpg",
      "title": "We Are Going On Bullrun Hyundai CArs"
    }
  ]
}"""

