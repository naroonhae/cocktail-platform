<template>

  <q-page
    class="flex flex-center"
    padding
  >
    <div
      class="full-width"
      style="max-width: 330px;"
    >
      <q-tabs
        class="text-grey"
        v-model="tab"
        indicator-color="primary"
        active-color="primary"
        narrow-indicator
      >
        <q-tab name="login" label="로그인"/>
        <q-tab name="register" label="회원가입"/>
      </q-tabs>


      <q-tab-panels v-model="tab" animated>
        <q-tab-panel name="login"><q-card>
            <login-form/>
        </q-card></q-tab-panel>

        <q-tab-panel name="register"><q-card>
            <register-form/>
        </q-card></q-tab-panel>
      </q-tab-panels>
    </div>
  </q-page>

</template>

<script>
import {defineComponent, ref} from "vue";
import LoginForm from "components/auth/LoginForm.vue";
import RegisterForm from "components/auth/RegisterForm.vue";

export default defineComponent({
  name: "AuthPage",
  components: {RegisterForm, LoginForm},
  setup() {
    return {
      tab: ref('login')
    }
  }
})
</script>

<style scoped>

</style>
