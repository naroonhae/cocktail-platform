<script>
export default {
  name: "MyValidation",
  methods: {
    required (val) {
      return  (val && val.length > 0 || '필수 필드들 입력해주세요.')
    },
  }
}
</script>
