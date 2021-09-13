# logger

A simple to use lightweight Logger for Java. This library makes it easy to setup Logging!

## Maven

```xml
<dependency>
	<groupId>com.github.niklasf119</groupId>
	<artifactId>logger</artifactId>
	<version>Tag</version>
</dependency>
```
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```

## Configuring the Logger

Available settings

1. `format.date`
   - String describing the format for logging timestamps
   - Default: dd MMM yyyy HH:mm:ss

1. `format.file`
   - String describing the format for the log-file name
   - Default: dd-MMM-yyyy_HH-mm-ss
   
1. `dest.console`
   - Boolean defining wether to log to the Console or not
   - Default: true
   
1. `dest.file`
   - Boolean defining wether to log to a File or not
   - Default: false
   
1. `log.level`
   - LogLevel defining the minimum level that is being logged
   - Default: LogLevel.ALL
   
1. `log.rollover`
   - Integer defining after how many days to change to a new logfile
   - Default: 0
   - Setting this value to 0 will disable rollover
   
1. `log.dir`
   - String defining the directory for the log files
   - Default: application directory

## Example configuration

```
format.date=dd MMM yyyy HH:mm:ss
format.file=dd-MMM-yyyy_HH-mm-ss
dest.console=true
dest.file=true
log.level=ALL
log.rollover=1
log.dir=C:\Users\Niklas\ownCloud\Hawolare\Core\logs
```
