# Stage 1: build application
FROM node:latest AS build-stage
WORKDIR /usr/src/app
COPY . .
RUN npm install && npm run build

# Stage 2: Serve App
FROM nginx:latest
COPY nginx.conf /etc/nginx/nginx.conf
WORKDIR /usr/share/nginx/html
COPY --from=build-stage /usr/src/app/dist/ .