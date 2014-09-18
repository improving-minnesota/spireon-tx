/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/
import org.openqa.selenium.Capabilities
import org.openqa.selenium.Dimension
import org.openqa.selenium.Platform
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.phantomjs.PhantomJSDriverService
import org.openqa.selenium.remote.DesiredCapabilities
// Use Firefox as the default driver
// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
driver = { new FirefoxDriver() }

// Automatic driver download code adapted from
// http://fbflex.wordpress.com/2013/01/06/geb-quickie-automatically-download-drivers-for-chrome-and-internet-explorer/
environments {

  // run as "grails -Dgeb.env=chrome test-app functional:"
  // See: http://code.google.com/p/selenium/wiki/ChromeDriver
  chrome {
    String chromeDriverVersion = "2.9"

    String chromeDriverZipFileName
    String chromeDriverExecFileName

    if (Platform.current.is(Platform.WINDOWS)) {
      chromeDriverZipFileName = "chromedriver_win32.zip"
      chromeDriverExecFileName = "chromedriver.exe"
    } else if (Platform.current.is(Platform.MAC)) {
      chromeDriverZipFileName = "chromedriver_mac32.zip"
      chromeDriverExecFileName = "chromedriver"
    } else if (Platform.current.is(Platform.LINUX)) {
      chromeDriverZipFileName = "chromedriver_linux32.zip"
      chromeDriverExecFileName = "chromedriver"
    } else {
      throw new RuntimeException("Unsupported operating system [${Platform.current}]")
    }

    String chromeDriverDownloadFullPath = "http://chromedriver.storage.googleapis.com/${chromeDriverVersion}/${chromeDriverZipFileName}"

    File chromeDriverLocalFile = downloadDriver(chromeDriverDownloadFullPath, chromeDriverExecFileName, 'zip')

    System.setProperty('webdriver.chrome.driver', chromeDriverLocalFile.absolutePath)
    driver = { new ChromeDriver() }
  }

  // run as "grails -Dgeb.env=ie test-app functional:"
  // See: https://code.google.com/p/selenium/wiki/InternetExplorerDriver
  ie {
    String ieDriverVersion = "2.40.0"
    String ieDriverVersionMajor = ieDriverVersion.substring(0, ieDriverVersion.lastIndexOf('.'))

    String ieDriverZipFileName = "IEDriverServer_Win32_${ieDriverVersion}.zip"

    String ieDriverDownloadFullPath = "http://selenium-release.storage.googleapis.com/${ieDriverVersionMajor}/${ieDriverZipFileName}"

    File ieDriverLocalFile = downloadDriver(ieDriverDownloadFullPath, "IEDriverServer.exe", 'zip')

    System.setProperty('webdriver.ie.driver', ieDriverLocalFile.absolutePath)
    driver = { new InternetExplorerDriver() }
  }

  // run as "grails -Dgeb.env=phantomjs test-app functional:"
  phantomjs {
    String phantomJSVersion = '1.9.2'

    String platform
    String archiveExtension
    String execFilePath

    if (Platform.current.is(Platform.WINDOWS)) {
      execFilePath = 'phantomjs.exe'
      platform = 'windows'
      archiveExtension = 'zip'
    }
    else if (Platform.current.is(Platform.MAC)) {
      execFilePath = '/bin/phantomjs'
      platform = 'macosx'
      archiveExtension = 'zip'
    } else if (Platform.current.is(Platform.LINUX)) {
      execFilePath = '/bin/phantomjs'
      platform = 'linux-i686'
      archiveExtension = 'tar.bz2'
    } else {
      throw new RuntimeException("Unsupported operating system [${Platform.current}]")
    }

    String phantomjsExecPath = "phantomjs-${phantomJSVersion}-${platform}/${execFilePath}"

    String phantomJsFullDownloadPath = "https://phantomjs.googlecode.com/files/phantomjs-${phantomJSVersion}-${platform}.${archiveExtension}"

    File phantomJSDriverLocalFile = downloadDriver(phantomJsFullDownloadPath, phantomjsExecPath, archiveExtension)

    System.setProperty('phantomjs.binary.path', phantomJSDriverLocalFile.absolutePath)
    driver = {
      Capabilities caps = DesiredCapabilities.phantomjs()
      def phantomJsDriver = new PhantomJSDriver(PhantomJSDriverService.createDefaultService(caps), caps)
      phantomJsDriver.manage().window().setSize(new Dimension(1028, 768))

      return phantomJsDriver
    }
  }
}

private File downloadDriver(String driverDownloadFullPath, String driverFilePath, String archiveFileExtension) {
  File destinationDirectory = new File("target/drivers")
  if (!destinationDirectory.exists()) {
    destinationDirectory.mkdirs()
  }

  File driverFile = new File("${destinationDirectory.absolutePath}/${driverFilePath}")

  String localArchivePath = "target/driver.${archiveFileExtension}"

  if (!driverFile.exists()) {
    def ant = new AntBuilder()
    ant.get(src: driverDownloadFullPath, dest: localArchivePath)

    if (archiveFileExtension == "zip") {
      ant.unzip(src: localArchivePath, dest: destinationDirectory)
    } else {
      ant.untar(src: localArchivePath, dest: destinationDirectory, compression: 'bzip2')
    }

    ant.delete(file: localArchivePath)
    ant.chmod(file: driverFile, perm: '700')
  }

  return driverFile
}