## Class XAudio

Windows音频控制。XAudio继承自IBaseAudio。

### 基类类型定义
类型 | 说明
--- | ---
[AudioDataCapturedCallBack](#XAudio::AudioDataCapturedCallBack) | 音频数据采集完成回调
[PlayEndedCallback](#XAudio::PlayEndedCallback) | 音频播放完成回调

### 基类成员函数
函数名 | 作用
--- | ---
[playWithInt16FormatBlock](#XAudio::playWithInt16FormatBlock) | 播放音频
[playWithInt16Format](#XAudio::playWithInt16Format) | 播放音频
[stopPlay](#XAudio::stopPlay) | 停止播放音频
[isPlaying](#XAudio::isPlaying) | 是否正在播放音频
[recordToBuf](#XAudio::recordToBuf) | 录制音频
[recordToCallback](#XAudio::recordToCallback) | 录制音频
[stopRecord](#XAudio::stopRecord) | 停止录音
[setPlayEndedCallBack](#XAudio::setPlayEndedCallBack) | 设置播放结束回调函数

### 成员函数
函数名 | 作用
--- | ---
[getSystemVolume](#XAudio::getSystemVolume) | 获取系统音量
[setSystemVolume](#XAudio::setSystemVolume) | 设置系统音量
[increaseSystemVolume](#XAudio::increaseSystemVolume) | 提高系统音量
[decreaseSystemVolume](#XAudio::decreaseSystemVolume) | 降低系统音量
[getPCMFormatForRecording](#XAudio::getPCMFormatForRecording) | 获取系统录音参数

<a id="XAudio::AudioDataCapturedCallBack"></a>
**AudioDataCapturedCallBack**
boost::function\<void (const DataBuffer&)\>
音频数据采集完成时的回调函数定义，函数参数传递采集数据的引用

<a id="XAudio::PlayEndedCallback"></a>
**PlayEndedCallback**
boost::function\<void (void)\>
音频播放完成时的回调函数定义

<a id="XAudio::playWithInt16FormatBlock"></a>
**playWithInt16FormatBlock**
bool playWithInt16FormatBlock(const DataBuffer& dataBuf, long int sampleRate)
播放一段采样率为sampleRate的16位音频，阻塞函数
*参数*
dataBuf - 播放数据的DataBuffer引用
sampleRate - 音频采样率
*返回*
顺利播放音频时为true
输入dataBuf、sampleRate无效，或系统音频错误时为false

<a id="XAudio::playWithInt16Format"></a>
**playWithInt16Format**
bool playWithInt16Format(const DataBuffer& dataBuf, long int sampleRate)
播放一段采样率为sampleRate的16位音频，非阻塞函数
*参数*
dataBuf - 播放数据的DataBuffer引用
sampleRate - 音频采样率
*返回*
顺利播放音频时为true
输入dataBuf、sampleRate无效，或系统音频错误时为false

<a id="XAudio::stopPlay"></a>
**stopPlay**
bool stopPlay()
*返回*
系统音频错误时为false

<a id="XAudio::isPlaying"></a>
**isPlaying**
bool isPlaying()
*返回*
正在播放音频时为true
未播放音频或系统音频错误时为false

<a id="XAudio::recordToBuf"></a>
**recordToBuf**
recordToBuf(DataBuffer& dataBuf)
recordToBuf(DataBuffer& dataBuf, PCMFormat& format)
*参数*
dataBuf - 采集数据的DataBuf引用
format - 音频格式
*返回*
系统音频错误时为false

<a id="XAudio::recordToCallback"></a>
**recordToCallback**
bool recordToCallback(AudioDataCapturedCallBack callback)
录制音频，录制结束后调用callback
*参数*
callback - 录制结束的回调函数
*返回*
系统音频错误时为false

<a id="XAudio::stopRecord"></a>
**stopRecord**
bool stopRecord()
*返回*
系统音频错误时为false

<a id="XAudio::setPlayEndedCallBack"></a>
**setPlayEndedCallBack**
void setPlayEndedCallBack(PlayEndedCallback callback)
*参数*
callback - 播放结束回调函数

<a id="XAudio::getSystemVolume"></a>
**getSystemVolume**
bool getSystemVolume(int* value)
*参数*
value - 系统音量的引用，值范围0-100
*返回*
系统音频错误时为false

<a id="XAudio::setSystemVolume"></a>
**setSystemVolume**
bool setSystemVolume(int value)
*参数*
value - 设置的系统音量，值范围0-100
*返回*
音量值超过范围或系统音频错误时为false

<a id="XAudio::increaseSystemVolume"></a>
**increaseSystemVolume**
bool increaseSystemVolume(int step)
*参数*
step - 音量提高值
*返回*
系统音频错误时为false

<a id="XAudio::decreaseSystemVolume"></a>
**decreaseSystemVolume**
bool decreaseSystemVolume(int step)
*参数*
step - 音量降低值
*返回*
系统音频错误时为false

<a id="XAudio::getPCMFormatForRecording"></a>
**getPCMFormatForRecording**
bool getPCMFormatForRecording(PCMFormat& format)
*参数*
format - 录音参数引用
*返回*
系统音频错误时为false

### 示例
```c++
XAudio audio;
DataBuffer buffer;
PCMFormat format;

format.numOfChannels = 1;       
format.numOfSamplePerSec = 16000;
format.numOfBitsPerSample = 16;

audio.recordToBuf(buffer, format);
getchar();
audio.stopRecord();
getchar();
audio.playWithInt16FormatBlock(buffer, 16000);
```


