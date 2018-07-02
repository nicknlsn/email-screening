<template>
    <div class="home">
        <!--<img src="../assets/logo.png">-->
        <!--<HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>-->
        <button v-on:click="test()">testing</button>
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
    export default class Home extends Vue {

        public test() {
            axios.get('/api/v1/test').then((response) => {
            });
        }
    }
</script>
