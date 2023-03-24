<script setup>
import { RouterView } from 'vue-router'
import NavBar from "@/components/navBar.vue";
import FooterV from "@/components/footerV.vue";

</script>

<template>
<nav-bar></nav-bar>

  <RouterView/>

<footerV></footerV>
</template>

<style>

body{
  min-height: 100%;
  background-image: url("assets/background.jpg");
  background-size: cover;
  background-repeat: no-repeat;
}
</style>
