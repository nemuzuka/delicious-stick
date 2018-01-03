package net.jp.vss

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import skinny.http.{HTTP, Request}

/**
  * 各種通知.
  */
object SlackNotification {

  /**
    * slack通知.
    * 環境変数のSLACK_URLが未指定の場合、SLACKへの通知は行いません
    */
  def send(): Unit = {
    val url = sys.env.getOrElse("SLACK_URL", "")
    if(url.nonEmpty) {
      val name = sys.env.getOrElse("SLACK_NAME", "dummy")
      val msg = sys.env.getOrElse("SLACK_MESSAGE", "今日はお休みします...")
      send(url=url, name=name, msg=msg)
    }
  }

  /**
    * 通知送信.
    * Incoming Webhooksの機能を使用して、
    * 引数のメッセージをSlackに表示します.
    * 本文は、名前\nメッセージとなります
    * @param url Slack通知用URL
    * @param name 名前.
    * @param msg メッセージ.
    * @return 正常終了しなかった時のエラーメッセージ _1:HTTPステータスコード _2:エラーbody (正常終了時はNone)
    */
  private[this] def send(url: String, name: String, msg: String): Option[(Int, String)] = {
    val mapper = new ObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val jsonStr = mapper.writeValueAsString(Param(text = s"$name\n$msg"))
    val request = Request(url).body(jsonStr.getBytes(HTTP.DEFAULT_CHARSET), "application/json")
    val response = HTTP.post(request)
    println(response.toString)
    if (200 <= response.status && response.status <= 399) None else Option((response.status, response.textBody))
  }

  /**
    * リクエスト用パラメータ.
    * @param text text項目
    */
  case class Param(text: String)
}
