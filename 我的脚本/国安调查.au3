WinMinimizeAll()
Sleep(1000)
SplashTextOn("中国国家安全局通知","通知：由于国家机密文件遭黑客窃取。为尽快找回文件，防止国家机密泄露。将对所有可疑计算机实施A级安检，请予以配合",500,220,-1,-1,-1,-1,24)
Sleep(7000)
SplashOff()
ProgressOn("国安A级加密", "加密中，禁止操作", "0%")
For $i = 10 To 100 Step 10
    Sleep(1000)
    ProgressSet( $i, $i & " %")
Next
ProgressSet(100 , "完成", "全部完成")
Sleep(500)
ProgressOff()
SplashTextOn("国安安检中","禁止操作",500,300,-1,-1,-1,-1,14)
Sleep(7000)
SplashOff()
Beep(500,5000)
SplashTextOn("检测报告","检测到国家绝密文件。为保证文件安全，将锁死该计算机，直至文件被国家取走。在此期间不得开机，否则将追究刑事责任",500,220,-1,-1,-1,-1,24)
Sleep(7000)
SplashOff()