net stop wuauserv
net stop cryptSvc
net stop bits
net stop msiserver
ren %systemroot%\SoftwareDistribution SoftwareDistribution.old
ren C:\Windows\System32\catroot2 catroot2.old
del "%ALLUSERSPROFILE%\Microsoft\Network\Downloader\qmgr0.dat" 
del "%ALLUSERSPROFILE%\Microsoft\Network\Downloader\qmgr1.dat"
net start wuauserv
net start cryptSvc
net start bits
net start msiserver
