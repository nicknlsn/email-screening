<template>
    <div class="home">
        <button v-on:click="chuck()">chuck norris</button>
    </div>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
    import axios from 'axios';

    @Component({
        components: {
            HelloWorld,
        },
    })
    export default class ChuckNorris extends Vue {

        public chuck() {
            axios.get('/api/v1/test').then((response) => {
            });
        }
    }
</script>