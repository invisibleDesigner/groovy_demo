package devops

def notify(String webhookId, service, branch, commit, commitTime, commiter) {

    String content = " 项目:         ${service}\n 分支:         ${branch}\n 提交:         ${commit}\n 提交人:     @${commiter}\n 提交时间: ${commitTime}\n 部署成功"

    String message = """
        {
            "msgtype": "text",
            "text": {
                "content": "${content}"
            }
        }
    """
    print(message);

    String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=${webhookId}";
    URLConnection post = new URL(url).openConnection();
    post.setRequestMethod("POST")
    post.setDoOutput(true)
    post.setRequestProperty("Content-Type", "application/json")
    post.getOutputStream().write(message.getBytes("UTF-8"));
    println(post.getInputStream().getText());
}

notify("3c676c3f-82a3-4e2a-9a49-df65b758e463", 1, 1, 1, 1,1)