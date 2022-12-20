<template>

    <q-form>
      <q-card-section>
        <q-input
          filled
          clearable
          required
          :rules="[]"
          class="q-mb-sm"
          label="Email"
          placeholder="email@example.com"
          type="email"
          v-model="email"
        />
        <q-input
          filled
          clearable
          required
          class="q-mb-sm"
          placeholder="email@example.com"
          label="Password"
          type="password"
          v-model="password"
        />
      </q-card-section>
      <q-card-actions>
        <q-btn
          class="full-width"
          color="primary"
          size="lg"
          label="Login"
          @click="submit"
        />
      </q-card-actions>
    </q-form>

</template>

<script>

import {defineComponent, ref} from "vue";

export default defineComponent({
  mixins: [],
  name: "LoginForm",
  methods: {
    required (val) {
      return  (val && val.length > 0 || '필수 필드들 입력해주세요.')
    },
    submit () {
      // todo: submit
    }
  },
  setup() {
    const email = ref(null);
    const password = ref(null);
    const rememberCheck = ref(false)

    return {
      email,
      password,
      rememberCheck
    }
  }
})

</script>

<style scoped>

</style>
