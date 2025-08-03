## Connect to rev control hub via UI
1. connect to wifi prefixed with FTC
2. Navigate `to 192.168.43.1:8080`

## Start/stop adb server and connec to rec control hub adb
- adb connect 192.168.43.1:5555
- adb start-server
- adb kill-server

#### The remote deployment just suddenly started working, I don't know why. If I figure out why, I need to document how to make that work.
It seems to be associated with running adb connect `192.168.43.1:5555` in the terminal after connecting to control hub wifi
