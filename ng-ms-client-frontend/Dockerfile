# Stage 1: build application
FROM node:14.8.0-alpine3.11 AS build-stage
WORKDIR /usr/src/app
COPY . .
RUN npm install && npm run build

# Stage 2: Serve App
FROM nginx:1.19.2-alpine
COPY nginx.conf /etc/nginx/nginx.conf
WORKDIR /usr/share/nginx/html
COPY --from=build-stage /usr/src/app/dist/ .