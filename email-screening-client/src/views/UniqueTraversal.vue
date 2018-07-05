<template>
    <div class="home">
        <button v-on:click="chuck()">unique traversal</button>
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
    export default class UniqueTraversal extends Vue {

        public chuck() {
        }
    }
</script>
