# Alexa Skill Sample

## 事前準備

- Java 8 JDK
- [Scala Build Tool](http://www.scala-sbt.org/)
- [AWS CLI](https://aws.amazon.com/cli/)


## はじめに

設定情報を準備します。

```
$ cp example-env.sh env.sh
//editorで env.shを編集してください
$ . env.sh
```

このプロジェクトをビルドして登録する場合は以下を実行します

```
$ sbt createLambda
```

lambdaとして登録されます。

**その後、`Alexa Skill Kit`との関連を手動で行ってください**

lambdaの環境変数には以下を設定する必要があります
- SLACK_URL
    - SlackのWebhookのURL
- SLACK_NAME
    - メッセージ内に含まれる名前
- SLACK_MESSAGE
    - メッセージ

functionの変更は以下を実行します

```
sbt updateLambda
```

インテントスキーマの設定は `alexa/` ディレクトリに保存します。

## 使い方
`Alexa、会社に連絡して`

- 会社に連絡(スキルの呼び出し名)

Alexaから`お大事に`というレスポンスが帰ってきたら成功です
