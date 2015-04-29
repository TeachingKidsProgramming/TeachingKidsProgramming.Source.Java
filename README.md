# TKP Source for Java

Welcome to the TKP Java API source repository.  

If you are looking for the TKP Java 'teaching repo', it is found in a companion location [here on GitHub](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java).
That repo contains a starter set (.jar) of .java files for teachers to use with students when teaching TKPJava.  It also contains a set of customizations for Eclipse that are specifically designed to make the coding experience more fun for beginners.

This repository contains the TKP Java API source used to create and support the teaching repository. Here we've implemented a Logo-like library, which includes objects such as a Turtle, Tortoise and many more.  We've also created documentation and examples specifically designed to be fun for kids ages 10-14 to learn to code.  We welcome feedback, suggestions and pull requests!  

# Contribute to TKP Java

We have a short document which describes our approach to courseware design.  It is [on penflip](https://www.penflip.com/lynnlangit/tkp-lesson-plans/blob/master/course100.txt)

## Cloud IDE (Codenvy)

An easy way to contribute is to click the 'Open in IDE' button below. This will open our repo in a customized Codenvy factory (web-based IDE). It's designed to facilitate your suggested updates by allowing you to code, build, run and also to make a pull request all from within the Codenvy environment.  

[![alt](https://codenvy.com/factory/resources/codenvy-contribute.svg)](https://codenvy.com/f?id=wvze4gb3kkwsvioa)

## Setup a local development environment
First [create your own a repository fork](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java#fork-destination-box).  Then, follow the instructions below to get started on your preferred platform.

### Mac OS X
Recent versions of Mac OS X come with `git` preinstalled.  So the first step is to clone your fork.  Open terminal then type the following:

```sh
mkdir -p ~/Documents/src
cd ~/Documents/src
```

Then clone the repository by typing the following command, you must replace `****` with your own github user name.

```sh
git clone https://github.com/********/TeachingKidsProgramming.Source.Java.git
```

You may be prompted to install "command line developer tools".  You can choose `Get Xcode` or `Install`.  However, `Get Xcode` takes much longer, so I would recommend starting with a simple `Install`.


![CommandLineTools.png](/images/OSXCommandLineTools.png?raw=true)

If you needed to install the command line tools you will have to run `git clone` again in order to actually clone the repository.

Next you will need java and eclipse.  You may already have them, but this guide assumes you are installing from scratch. Let's use homebrew to get the tools we need.

First visit the [homebrew page](http://brew.sh/) and follow the instructions there to install the `brew` command.

Next use this command to install [Homebrew Cask](http://caskroom.io/):
```sh
brew install caskroom/cask/brew-cask
```

Now you can install Java:
```sh
brew cask install java
```

Now install eclipse for Java:
```sh
brew cask install eclipse-java
```
Eclipse can take a while to download, so be patient.

Now you can start eclipse, any easy way to do that is to launch it using spotlight:

1. Press Cmd+Space
1. Type `ec`
1. Select `eclipse`

When eclipse launches, it will ask you where to put your workspace.  The default is `~/Documents/workspace` and this is fine.

Once eclipse finishes creating and loading the workspace, you can use the `File` menu to choose `Import`.  Type `maven` in the filter box, and choose `Existing Maven Projects`.  Click `Next`, then click `Browse...`.  Navigate to `Documents` then `src` then select `TeachkingKidsProgramming.Source.Java`, and click `Open`.  Now click `Finish`.

Now click the `Workbench` icon in the upper right corner.

![Workbench.png](/images/OSXWorkbench.png?raw=true)

Next, do a quick test to see if everything is working:

1. Press Cmd+Shift+T in eclipse to search the TKP project.
1. Enter `SimpleSquare` in the search box.
1. Choose the `completed` recipe

    ![completed](/images/OSXSimpleSquare.png?raw=true)
    
1. Click `Ok`
1. Right-click on `public class SimpleSquare`
1. Choose `Run As` then `Java Application`

You should see the tortoise appear and draw a square:

![Tortoise](/images/OSXTortoise.png?raw=true)

### Linux
These instructions apply to Ubuntu 14.10, and you may need to modify some commands to work on your distribution.

Ubuntu comes with a package manager and we will use it to install required applications as we go.  First open a terminal then type the following:
```sh
mkdir -p ~/src
cd ~/src
sudo apt-get install -y git
```

Then clone the repository by typing the following command, you must replace `****` with your own github user name.

```sh
git clone https://github.com/********/TeachingKidsProgramming.Source.Java.git
```
Now install java with these commands
```sh
sudo apt-get update
sudo apt-get install -y openjdk-8-jdk
```

Now install eclipse, visit [eclipse.org](https://www.eclipse.org/downloads) using your browser.  The website should be able to detect your operating system and provide you with links to the Linux distributions.  Most likely you will want to install the 64-bit version of eclipse.  Download it to the default download location (`~/Downloads` for Firefox).

Next type the following commands:
```sh
mkdir -p ~/apps
tar xzvf ~/Downloads/eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz -C ~/apps/
sudo ln -s ~/apps/eclipse/eclipse /usr/local/bin
```
Now you can start eclipse, an easy way to do that is to launch it using the terminal with this command:

```sh
eclipse &
```
When eclipse launches, it will ask you where to put your workspace.  The default is `~/workspace` and this is fine.

When eclipse finishes creating and launching the workspace use the `File` menu to choose `Import`.  Type `maven` in the filter box, and choose `Existing Maven Projects`.  Click `Next`, then click `Browse...`.  Navigate to your home directory then `src` then select `TeachkingKidsProgramming.Source.Java`, and click `Ok`.  Now click `Finish`.

Now click the `Workbench` icon in the lower center of the eclipse window:

![Workbench](/images/UbuntuWorkbench.png?raw=true)

Next, perform a quick test to see that everything is working:

1. Press Ctrl+Shift+T in eclipse to search the TKP project.
1. Enter `SimpleSquare` in the search box.
1. Choose the `completed` recipe
    
    ![completed](/images/UbuntuSimpleSquare.png?raw=true)
    
1. Click `Ok`
1. Right-click on `public class SimpleSquare`
1. Choose `Run As` then `Java Application`

You should see the tortoise appear and draw a square:

![Tortoise](/images/UbuntuTortoise.png?raw=true)

### Windows

First we will need to add a `git` package to windows.  Go to the [msysgit site](https://msysgit.github.io/) and download the installer.  Click `Run` when it completes.  Agree to the UAC prompt then wizard will launch.  You can accept the defaults for most pages, but choose `Use Git from the Windows Command Prompt` on the `Adjusting your PATH environment` page.  On the next page, titled `Configuring the line ending conversions` choose `Checkout as-is, commit as-is`.  Finish the wizard.

Next start a command prompt:

1. Press Windows+R
2. Type `cmd`
3. Press `Enter`

Now enter the following commands:
```cmd
mkdir Documents\src
cd Documents\src
```

Then clone the repository by typing the following command, you must replace `****` with your own github user name.

```sh
git clone https://github.com/********/TeachingKidsProgramming.Source.Java.git
```

Next you will need java and eclipse.  We will use ninite.com to install these packages.  Click this [link](https://ninite.com/eclipse-jdkx8/) to get a custom package that will install java and eclipse.  Run the package, accept the UAC prompt and ninite will install the tools.

Now start eclipse using the shortcut placed on the desktop.  When eclipse launches, it will ask you where to put your workspace.  The default is in `workspace` under your user profile and this is fine.

When eclipse finishes creating and launching the workspace use the `File` menu to choose `Import`.  Type `maven` in the filter box, and choose `Existing Maven Projects`.  Click `Next`, then click `Browse...`.  Select `Documents\src\TeachkingKidsProgramming.Source.Java`, and click `Ok`.  Now click `Finish`.

Now click the `Workbench` icon in the upper left corner of the eclipse window:

![Workbench](/images/WinWorkbench.png?raw=true)

1. Press Ctrl+Shift+T in eclipse to search the TKP project.
1. Enter `SimpleSquare` in the search box.
1. Choose the `completed` recipe

    ![completed](/images/WinSimpleSquare.png?raw=true)

1. Click `Ok`
1. Right-click on `public class SimpleSquare`
1. Choose `Run As` then `Java Application`

You should see the tortoise appear and draw a square:

![Tortoise](/images/WinTortoise.png?raw=true)











