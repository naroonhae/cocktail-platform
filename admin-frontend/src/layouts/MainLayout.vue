<template>
  <q-layout view="lHh lpr lFf">
    <main-header/>

    <q-page-container>
      <router-view />
    </q-page-container>

    <main-footer/>

  </q-layout>

</template>

<script>
import { defineComponent } from 'vue';
import MainHeader from "components/common/MainHeader.vue";
import MainFooter from "components/common/MainFooter.vue";

export default defineComponent({
  name: 'MainLayout',

  components: {
    MainFooter,
    MainHeader
  },

  setup () {
    return {

    }
  }
});
</script>
