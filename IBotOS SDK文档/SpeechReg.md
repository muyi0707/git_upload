## Class SpeechReg

将语音提交至服务器并获取语音识别结果。

### 成员函数
函数名 | 作用
--- | ---
[SpeechReg](#SpeechReg::SpeechReg) | 构造函数
[setParams](#SpeechReg::setParams) | 设置参数
[getParams](#SpeechReg::getParams) | 获取参数
[getRegResult](#SpeechReg::getRegResult) | 提交语音并获取识别结果
[httpBody](#SpeechReg::httpBody) | 获取Http响应信息
[httpHeaders](#SpeechReg::httpHeaders) | 获取Http响应头
[httpCode](#SpeechReg::httpCode) | 获取Http响应代码
[getCallBackWriteBuf](#SpeechReg::getCallBackWriteBuf) | 获取识别结果

<a id="SpeechReg::SpeechReg"></a>
**SpeechReg**
SpeechReg(const SpeechRegParams& params)
SpeechReg(const SpeechRegParams& params, const iBotSignature& signature)
*参数*
params - SpeechReg参数
signature - CloudSDK签名

<a id="SpeechReg::setParams"></a>
**setParams**
void setParams(const SpeechRegParams& params)
*参数*
params - SpeechReg参数

<a id="SpeechReg::getParams"></a>
**getParams**
const SpeechRegParams& getParams() const
*返回*
SpeechReg参数的引用

<a id="SpeechReg::getRegResult"></a>
**getRegResult**
bool getRegResult(const DataBuffer& audioBuf)
*参数*
audioBuf - speex编码音频数据，16位单声道16000Hz
*返回*
获得服务器返回的应答时为true
SpeechReg参数设置不正确、音频内容为空、服务器无应答时为false

<a id="SpeechReg::httpBody"></a>
**httpBody**
const void\* httpBody(long &size)
*参数*
size - Http响应信息大小引用
*返回*
Http响应信息字符串指针

<a id="SpeechReg::httpHeaders"></a>
**httpHeaders**
std::vector\<std::string\>& httpHeaders()
*返回*
Http响应头

<a id="SpeechReg::httpCode"></a>
**httpCode**
long httpCode()
*返回*
Http响应信息

<a id="SpeechReg::getCallBackWriteBuf"></a>
**getCallBackWriteBuf**
const std::string& getCallBackWriteBuf()
*返回*
语音识别结果字符串引用

### 示例
```c++
SpeechRegParams params;
params.setURL("http://vcloud.xiaoi.com/recog");
params.setTotalTimeout(10);

SpeechReg recognizer(params);

// Record sound and encode to speex 
// DataBuffer buffer;
...

if(recognizer.getRegResult(buffer))
{
    std::cout << "Recognize result: " << recognizer.getCallBackWriteBuf() << std::endl;
}
else
{
    std::cout << "Recognize failed" << std::endl;
}
```

