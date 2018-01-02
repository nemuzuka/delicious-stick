package net.jp.vss

import com.amazon.speech.speechlet._
import net.jp.vss.speech.ui.VssPlainTextOutputSpeech
import net.jp.vss.speech.speechlet.VssSpeechletResponse

class VssSpeechlet extends Speechlet {

  override def onSessionStarted(request: SessionStartedRequest, session: Session): Unit = {
    logInvocation("onSessionStarted", request, session)
  }

  override def onLaunch(request: LaunchRequest, session: Session): VssSpeechletResponse = {
    logInvocation("onLaunch", request, session)

    //通知
    SlackNotification.send()

    new VssSpeechletResponse(new VssPlainTextOutputSpeech("承知しました、飲み過ぎましたか？"))
  }

  override def onIntent(request: IntentRequest, session: Session): VssSpeechletResponse = {
    logInvocation("onIntent", request, session)

    //通知
    SlackNotification.send()

    new VssSpeechletResponse(new VssPlainTextOutputSpeech("あらら、お大事に"))
  }

  override def onSessionEnded(request: SessionEndedRequest, session: Session): Unit = {
    logInvocation("onSessionEnded", request, session)
  }

  private def logInvocation(name: String, request: SpeechletRequest, session: Session): Unit = {
    val requestId = request.getRequestId
    val sessionId = session.getSessionId
    println(s"$name requestId=$requestId sessionId=$sessionId")
  }
}
