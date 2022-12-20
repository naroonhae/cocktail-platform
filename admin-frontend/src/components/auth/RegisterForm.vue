<template>

    <q-form>
      <q-card-section>
        <q-input
          filled
          clearable
          lazy-rules
          :rules="[this.required, this.isEmail, this.short]"
          class="q-mb-sm"
          label="Email"
          placeholder="email@example.com"
          type="email"
          v-model="email"
        />
        <q-input
          filled
          clearable
          lazy-rules
          :rules="[this.required, this.short]"
          class="q-mb-sm"
          placeholder="김ㅇㅇ"
          label="Username"
          type="username"
          v-model="username"
        />
        <q-input
          filled
          clearable
          lazy-rules
          :rules="[this.required, this.short]"
          class="q-mb-sm"
          placeholder="01012345678"
          label="Phone"
          type="phone"
          v-model="phone"
        />
        <q-input
          filled
          clearable
          lazy-rules
          :rules="[this.required, this.short]"
          class="q-mb-sm"
          placeholder="email@example.com"
          label="Password"
          type="password"
          v-model="password"
        />
        <q-input
          filled
          clearable
          lazy-rules
          :rules="[this.required, this.short, this.diffPassword]"
          class="q-mb-sm"
          placeholder="Confirm Password"
          label="Confirm password"
          :type="passwordFieldType"
          v-model="confirmPassword"
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
  name: "RegisterForm",
  methods: {
    required (val) {
      return  (val && val.length > 0 || '필수 필드들 입력해주세요.')
    },
    diffPassword (val) {
      const val2 = this.password
      return (val && (val===val2) || '비밀번호가 일치하지 않습니다.')
    },
    short(val) {
      return  (val && val.length > 3 || '3글자 이상 입력해주세요.')
    },
    isEmail (val) {
      const emailPattern = /^(?=[a-zA-Z0-9@._%+-]{6,254}$)[a-zA-Z0-9._%+-]{1,64}@(?:[a-zA-Z0-9-]{1,63}\.){1,8}[a-zA-Z]{2,63}$/
      return (emailPattern.test(val) || '이메일 형식이 아닙니다.')
    },
    submit () {
      // todo: submit
    }
  },
  setup() {
    const email = ref(null);
    const username = ref(null);
    const phone = ref(null);
    const password = ref(null);
    const confirmPassword= ref(null);

    return {
      tab: ref('login'),
      email,
      username,
      phone,
      password,
      confirmPassword
    }
  }
})
</script>

<style scoped>

</style>
