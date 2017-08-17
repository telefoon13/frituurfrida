<jsp:useBean id="adres" scope="request" type="be.vdab.enteties.Adres"/>
<jsp:useBean id="openGesloten" scope="request" type="be.vdab.enteties.OpenGesloten"/>

<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html lang="nl">
<head>
    <title>Frituur Frida</title>
    <link rel="icon" href="../../images/favicon.ico">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="../../style/default.css">
</head>
<body>
<h1>Frituur Frida</h1>
<h2>Vandaag zijn we </h2>
<img src="../../images/${openGesloten}.png" alt="${openGesloten}">
<br>
<h3>Adres</h3>
${adres.straat} ${adres.huisNr}<br>
${adres.gemeente.postCode} ${adres.gemeente.naam}
</body>
</html>
