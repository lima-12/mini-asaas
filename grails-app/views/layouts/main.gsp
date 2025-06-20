<!doctype html>
<html lang="pt-BR">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
    <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="layouts/main.css" />
    <link
            rel="stylesheet"
            href="https://atlas.asaas.com/reset.css"
            crossorigin="anonymous">
    <link
            rel="stylesheet"
            href="https://atlas.asaas.com/v26.3.1/atlas.css"
            crossorigin="anonymous">
    <script
            defer
            src="https://atlas.asaas.com/v26.3.1/atlas.js"
            crossorigin="anonymous"
    ></script>

    <g:layoutHead/>

</head>
<body class="has-atlas">
<atlas-screen>
    <g:render template="/components/navbar" />
    <g:render template="/components/sidebar" />
    <atlas-page class="js-atlas-page">
    <atlas-page-header
            slot="header"
            page-name="${pageProperty(name: "body.page-title")}"
        >
            <atlas-breadcrumb slot="breadcrumb">
                <atlas-breadcrumb-item text="${pageProperty(name: "body.page-title")}" icon="home"></atlas-breadcrumb-item>
            </atlas-breadcrumb>
        </atlas-page-header>
        <atlas-page-content slot="content" class="js-atlas-content">
            <g:layoutBody />
        </atlas-page-content>
    </atlas-page>
</atlas-screen>
</body>
</html>