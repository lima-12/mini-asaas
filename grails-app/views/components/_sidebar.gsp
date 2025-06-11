<%-- Conteúdo do seu menu lateral virá aqui --%>
<atlas-sidebar slot="sidebar">
    <atlas-sidebar-menu slot="body">
        <atlas-sidebar-menu-item
                text="Dashboard"
                icon="home" href="/"
        ></atlas-sidebar-menu-item>

        <atlas-sidebar-menu-item
                text="Pagadores"
                icon="users"
                href="${createLink(uri: '/payer')}"
%{--                active--}%
        ></atlas-sidebar-menu-item>
    </atlas-sidebar-menu>
</atlas-sidebar>