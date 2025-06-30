FROM maven:3.9.6-eclipse-temurin-17

# Install Chrome
RUN apt update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    fonts-liberation \
    libappindicator3-1 \
    libasound2 \
    libatk-bridge2.0-0 \
    libatk1.0-0 \
    libcups2 \
    libdbus-1-3 \
    libgdk-pixbuf2.0-0 \
    libnspr4 \
    libnss3 \
    libxcomposite1 \
    libxdamage1 \
    libxrandr2 \
    xdg-utils \
    libu2f-udev \
    libvulkan1 \
    && rm -rf /var/lib/apt/lists/*

# Install Chrome stable
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list' && \
    apt update && apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Set workdir
WORKDIR /project

# Copy project files
COPY . .

# Run tests by default
CMD ["mvn", "clean", "test"]
