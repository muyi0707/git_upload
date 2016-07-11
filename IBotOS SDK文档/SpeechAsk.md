## Class SpeechAsk

将对话内容提交至服务器并获取应答。

### 成员函数
函数名 | 作用
--- | ---
[SpeechAsk](#SpeechAsk::SpeechAsk) | 构造函数
[setParams](#SpeechAsk::setParams) | 设置参数
[getParams](#SpeechAsk::getParams) | 获取参数
[getAnswer](#SpeechAsk::getAnswer) | 提交对话内容并获取应答
[getHttpResponseCode](#SpeechAsk::getHttpResponseCode) | 获取Http响应代码
[getHttpResponseHeaders](#SpeechAsk::getHttpResponseHeaders) | 获取Http响应头
[getHttpResponseBody](#SpeechAsk::getHttpResponseBody) | 获取Http响应信息

<a id="SpeechAsk::SpeechAsk"></a>
**SpeechAsk::SpeechAsk**
SpeechAsk(const SpeechAskParams& params)
SpeechAsk(const SpeechAskParams& params, const iBotSignature& signature)
*参数*
params - SpeechAsk参数
signature - CloudSDK签名

<a id="SpeechAsk::setParams"></a>
**SpeechAsk::setParams**
void setParams(const SpeechAskParams& params)
*参数*
params - SpeechAsk参数

<a id="SpeechAsk::getParams"></a>
**SpeechAsk::getParams**
const SpeechAskParams& getParams() const
*返回*
SpeechAsk参数的引用

<a id="SpeechAsk::getAnswer"></a>
**SpeechAsk::getAnswer**
bool getAnswer(const std::string& question, std::string& answer)
*参数*
question - 对话内容
answer - 服务器返回的应答
*返回*
获得服务器返回的应答时为true
SpeechAsk参数设置不正确、对话内容为空、服务器无应答时为false

<a id="SpeechAsk::getHttpResponseCode"></a>
**SpeechAsk::getHttpResponseCode**
long getHttpResponseCode()
*返回*
Http响应代码

<a id="SpeechAsk::getHttpResponseHeaders"></a>
**SpeechAsk::getHttpResponseHeaders**
std::vector\<std::string\>& getHttpResponseHeaders()
*返回*
Http响应头

<a id="SpeechAsk::getHttpResponseBody"></a>
**SpeechAsk::getHttpResponseBody**
const std::string& getHttpResponseBody()
*返回*
Http响应信息

### 示例
```c++
SpeechAskParams params;
params.setPlatform("ios");
params.setURL("http://nlp.xiaoi.com/ask");
params.setUserId("random");
params.setTotalTimeout(10);

SpeechAsk ask(params);

std::string question;
std::string answer;

question = "今天天气怎么样";
std::cout << "Question: " << question << std::endl;

if(ask.getAnswer(question, answer))
{
    std::cout << "Answer: " << answer << std::endl;
}
else
{
    std::cout << "Get Answer Failed" << std::endl;
}
```


