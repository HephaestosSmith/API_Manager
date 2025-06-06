FROM node:16-alpine as build-stage
WORKDIR /app
COPY . .
RUN npm install && npm run build:prod

FROM nginx:alpine
COPY --from=build-stage /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80