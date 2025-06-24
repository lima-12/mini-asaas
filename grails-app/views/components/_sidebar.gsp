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
        ></atlas-sidebar-menu-item>

        <atlas-sidebar-menu-item
                text="Pagamentos"
                icon="hand-holding-money"
                href="${createLink(uri: '/payment')}"
        ></atlas-sidebar-menu-item>
    </atlas-sidebar-menu>
</atlas-sidebar>