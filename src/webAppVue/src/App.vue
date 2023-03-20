<script setup>
import { RouterLink, RouterView } from 'vue-router'
import NavBar from "@/components/navBar.vue";
import FooterV from "@/components/footerV.vue";

</script>

<template>
<nav-bar></nav-bar>
  <body>
  <RouterView class="bode"/>
  </body>
<footerV></footerV>
</template>

<style>

body{
  min-height: 100%;
  background-image: url("assets/background.jpg");
  background-size: cover;
}
</style>
