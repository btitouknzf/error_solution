net stop wuauserv
net stop cryptSvc
net stop bits
net stop msiserver
rmdir c:\windows\softwaredistribution.old /q /s
rmdir c:\Windows\System32\catroot2.old /q /s
net start wuauserv
net start cryptSvc
net start bits
net start msiserver
