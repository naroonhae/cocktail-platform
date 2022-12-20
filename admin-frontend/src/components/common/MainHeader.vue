<template>

  <q-header class="bg-white text-black" height-hint="98">
    <q-toolbar>
      <q-toolbar-title>
        <q-btn
          flat dense round
          icon="home"
          to="/"
        />
        {{title}}
      </q-toolbar-title>

      <div class="gt-sm">
        <q-tabs
          class="absolute-center"
          indicator-color="transparent"
          v-model="tab"
        >
          <q-route-tab
            v-for="page in pages"
            :key="page.title"
            :to="page.link"
            :label="page.title"
            active-class="text-red"
          />
        </q-tabs>

        <div class="absolute-right">
          <q-btn
            class="q-ma-xs q-mr-md"
            dense flat
            to="/sign-in"
            icon="login"
          />
        </div>
      </div>
      <div class="lt-md">
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleDrawer"
        />

        <q-drawer
          v-model="drawerOpen"
          show-if-above
          side="right"
          behavior="mobile"
          bordered
        >
          <q-list>
            <q-item-label
              class="text-h5"
              header
            >
              {{title}}
            </q-item-label>
            <drawer-link
              v-for="page in pages"
              v-bind="page"
              :key="page.title"
            />
          </q-list>
        </q-drawer>
      </div>
    </q-toolbar>
  </q-header>
</template>

<script>
import {defineComponent, ref} from "vue";
import DrawerLink from "components/common/DrawerLink.vue";

const title = "Cocktail"
const pages = [
  {
    title: "Page One",
    caption: "/page-one",
    icon: "school",
    link: "/page-one"
  },
  {
    title: "Page Two",
    caption: "/page-two",
    icon: "code",
    link: "/page-two"
  },
  {
    title: "Page Three",
    caption: "/page-three",
    icon: "chat",
    link: "/page-three"
  }
]

export default defineComponent({
  name: 'MainHeader',
  components: { DrawerLink },
  setup () {
    const drawerOpen = ref(false)

    return {
      title,
      pages,
      drawerOpen,
      toggleDrawer () {
        drawerOpen.value = !drawerOpen.value
      }
    }
  }
});

</script>
