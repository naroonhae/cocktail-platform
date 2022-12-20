
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '/main',
        component: () => import('pages/IndexPage.vue')
      },
      {
        path: '/sign-in',
        component: () => import('pages/AuthPage.vue')
      },
      {
        path: '/page-one',
        component: () => import('pages/IndexPage.vue')
      }
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
