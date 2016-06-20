## Class SpeechSynth

文字提交至服务器获取语音合成结果。

### 成员函数
函数名 | 作用
--- | ---
[SpeechSynth](#SpeechSynth::SpeechSynth) | 构造函数
[setParams](#SpeechSynth::setParams) | 设置参数
[getParams](#SpeechSynth::getParams) | 获取参数
[getSpeech](#SpeechSynth::getSpeech) | 提交文字并获取语音合成结果
[httpBody](#SpeechSynth::httpBody) | 获取Http响应信息
[httpHeaders](#SpeechSynth::httpHeaders) | 获取Http响应头
[httpCode](#SpeechSynth::httpCode) | 获取Http响应代码

<a id="SpeechSynth::SpeechSynth"></a>
**SpeechSynth**
SpeechSynth(const SpeechSynthParams& params)
SpeechSynth(const SpeechSynthParams& params, const iBotSignature& signature)
*参数*
params - SpeechSynth参数
signature - CloudSDK签名

<a id="SpeechSynth::setParams"></a>
**setParams**
void setParams(const SpeechSynthParams& params)
*参数*
params - SpeechSynth参数

<a id="SpeechSynth::getParams"></a>
**getParams**
const SpeechSynthParams& getParams() const
*返回*
SpeechSynth参数的引用

<a id="SpeechSynth::getSpeech"></a>
**getSpeech**
bool getSpeech(const std::string& content)
*参数*
content - 待语音合成的文字字符串引用
*返回*
获得服务器返回的应答时为true
SpeechSynth参数设置不正确、服务器无应答时为false

<a id="SpeechSynth::httpBody"></a>
**httpBody**
const void\* httpBody(long &size)
*参数*
size - Http响应信息大小引用
*返回*
Http响应信息，内容为speex编码音频数据，16位单声道8000Hz

<a id="SpeechSynth::httpHeaders"></a>
**httpHeaders**
std::vector\<std::string\>& httpHeaders()
*返回*
Http响应头

<a id="SpeechSynth::httpCode"></a>
**httpCode**
long httpCode()
*返回*
Http响应信息

### 示例
```c++
SpeechSynthParams params;
params.setURL("http://vcloud.xiaoi.com/synth.do");
params.setTotalTimeout(10);

SpeechSynth synthesizer(param);

if(synthesizer.getSpeech("你好"))
{
    void pBuffer = NULL;
    long bufferSize = 0;
    pBuffer = synthesizer.httpBody(bufferSize);
    
    DataBuffer buffer((unsigned char*)pBuffer, bufferSize);
    // Decode from speex to pcm
    // Play sound
    ...
    
    std::cout << "Get Speech Succeed" << std::endl;
}
else
{
    std::cout << "Get Speech Failed" << std::endl;
}
```

