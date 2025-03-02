<template>
  <div id="app" ref="app">
    <WeatherComponent />
    <div class="main-content">
      <TodoComponent />
      <NewsComponent />
    </div>
  </div>
</template>

<script>
import WeatherComponent from './components/WeatherComponent.vue';
import TodoComponent from './components/TodoComponent.vue';
import NewsComponent from './components/NewsComponent.vue';

export default {
  name: 'App',
  components: {
    WeatherComponent,
    TodoComponent,
    NewsComponent,
  },
  mounted() {
    this.fullscreen();
  },
  methods: {
    fullscreen() {
      if (this.$refs.app.requestFullscreen) {
        this.$refs.app.requestFullscreen();
      } else if (this.$refs.app.mozRequestFullScreen) { // Firefox
        this.$refs.app.mozRequestFullScreen();
      } else if (this.$refs.app.webkitRequestFullscreen) { // Chrome, Safari and Opera
        this.$refs.app.webkitRequestFullscreen();
      } else if (this.$refs.app.msRequestFullscreen) { // IE/Edge
        this.$refs.app.msRequestFullscreen();
      }
    }
  }
};
</script>

<style>
html,
body {
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: black;
  color: lightslategrey;
  cursor: none; 
}

#app {
  display: flex;
  flex-direction: column;
  height: 100vh;
}

.main-content {
  display: flex;
  flex-grow: 1;
}
</style>